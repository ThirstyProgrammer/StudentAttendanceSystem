package id.bachtiar.harits.studentattendancesystem.feature.form

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentFormBinding
import id.bachtiar.harits.studentattendancesystem.model.AttendanceForm
import id.bachtiar.harits.studentattendancesystem.model.StudentDialog
import id.bachtiar.harits.studentattendancesystem.model.firebase.ScheduleModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel
import id.bachtiar.harits.studentattendancesystem.util.*
import java.util.*

class FormFragment : Fragment(), DialogListener, StudentNotPresentAdapterListener {

    private lateinit var viewBinding: FragmentFormBinding
    private lateinit var viewModel: FormViewModel
    private lateinit var dialog: DialogStudentNotPresent
    private lateinit var studentNotPresentAdapter: StudentNotPresentAdapter
    private lateinit var scheduleModel: ScheduleModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFormBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(FormViewModel::class.java)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sharedPreferences = requireActivity().application.getSharedPreferences(
            Constant.Config.APP_PREFERENCE,
            Context.MODE_PRIVATE
        )

        scheduleModel = FormFragmentArgs.fromBundle(arguments as Bundle).schedule
        studentNotPresentAdapter = StudentNotPresentAdapter()
        studentNotPresentAdapter.setListener(this)
        val linearLayoutManager = LinearLayoutManager(requireContext())

        viewBinding.apply {
            tvName.text = scheduleModel.subject
            tvGrade.text = scheduleModel.grade
            tvIntervalHour.text =
                "${scheduleModel.startTime} - ${scheduleModel.endTime}"
            tvDate.text = StringHelper.getCurrentDate()
            dialog = DialogStudentNotPresent()
            btnBack.setOnClickListener {
                requireActivity().finish()
            }
            btnAddStudentNotPresent.setOnClickListener {
                dialog.show(parentFragmentManager, "STUDENT NOT PRESENT")
                dialog.setupListener(this@FormFragment)
            }

            val dividerItemDecoration =
                DividerItemDecoration(rvStudents.context, linearLayoutManager.orientation)
            rvStudents.apply {
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
                adapter = studentNotPresentAdapter
                addItemDecoration(dividerItemDecoration)
            }
            btnSubmit.setOnClickListener {
                generateFormData()
            }
        }
        getStudents(scheduleModel.grade.toEmpty())
    }

    override fun onButtonPositiveClicked(studentDialog: StudentDialog) {
        viewBinding.apply {
            tvEmptyStudents.setViewVisibility(false)
            rvStudents.setViewVisibility(true)
        }
        studentNotPresentAdapter.addData(studentDialog)
    }

    override fun onEmptyList() {
        viewBinding.apply {
            tvEmptyStudents.setViewVisibility(true)
            rvStudents.setViewVisibility(false)
        }
    }

    override fun onItemRemoved(studentNotPresent: StudentDialog) {
        dialog.studentItems.add(studentNotPresent.student)
    }

    private fun getStudents(grade: String) {
        val collectionPath = grade.toCollectionOrDocumentPath()
        viewModel.getStudentByClass(collectionPath) { data ->
            data.forEach {
                dialog.studentItems.add(it.name.toDash())
            }
        }
    }

    private fun generateFormData() {
        val totalStudentPresent = viewModel.students.size - studentNotPresentAdapter.getData().size
        val formData = AttendanceForm(
            teachingMedia = viewBinding.teachingMedia.toString(),
            learningMaterials = viewBinding.learningMaterials.toString(),
            obstaclesAndSolution = viewBinding.obstaclesAndSolution.toString(),
            grade = scheduleModel.grade.toEmpty(),
            subject = scheduleModel.subject.toEmpty(),
            date = StringHelper.getCurrentDate(),
            totalStudentPresent = totalStudentPresent
        )
        // TODO Create Document In Form Collection
        viewModel.formDocumentPath = "${getSubject()}-${getGrade()}-${getDate()}"
        viewModel.createFormDocument(
            formData,
            ::onSuccessCreateForm,
            ::onFailedCreateForm
        )
    }

    private fun onSuccessCreateForm() {
        // TODO Update Collection Class
        viewModel.notPresentStudent.addAll(studentNotPresentAdapter.getData())
        viewModel.updateClass(getGrade(), ::onSuccessUpdateClass, ::onFailedUpdateClass)
    }

    private fun onFailedCreateForm() {
        Toast.makeText(requireContext(), "Maaf data anda gagal tersimpan", Toast.LENGTH_SHORT)
            .show()
    }

    private fun onSuccessUpdateClass() {
        val collectionPath = viewModel.sharedPreferences.getUserName().toCollectionOrDocumentPath()
        val documentPath = "${getDay()}-${getSubject()}-${getGrade()}"
        scheduleModel.updatedAt = StringHelper.getCurrentDate()
        viewModel.updateScheduleLastUpdated(
            collectionPath,
            documentPath,
            scheduleModel,
            ::onSuccessUpdateSchedule,
            ::onFailedUpdateSchedule
        )
    }

    private fun onFailedUpdateClass() {
        viewModel.deleteFormDocument()
        Toast.makeText(requireContext(), "Maaf data anda gagal tersimpan", Toast.LENGTH_SHORT)
            .show()
    }

    private fun onSuccessUpdateSchedule() {
        viewModel.students.forEach { studentModel ->
            val collectionPath = studentModel.name.toEmpty().toCollectionOrDocumentPath()
            val documentPath =
                "${scheduleModel.subject.toEmpty().toCollectionOrDocumentPath()}-${getDate()}"
            val attendanceModel = StudentAttendanceModel(
                subject = scheduleModel.subject,
                startTime = scheduleModel.startTime,
                endTime = scheduleModel.endTime,
                date = StringHelper.getCurrentDate(),
                status = getStatus(studentModel)
            )
            viewModel.addStudentAttendance(
                collectionPath,
                documentPath,
                attendanceModel,
                ::onSuccessAddStudentAttendance,
                ::onFailedAddStudentAttendance
            )
        }
    }

    private fun onFailedUpdateSchedule() {
        viewModel.deleteFormDocument()
        Toast.makeText(requireContext(), "Maaf data anda gagal tersimpan", Toast.LENGTH_SHORT)
            .show()
    }

    private fun onSuccessAddStudentAttendance() {
        Toast.makeText(requireContext(), "Data Telah Berhasil Disimpan", Toast.LENGTH_LONG).show()
        requireActivity().finish()
    }

    private fun onFailedAddStudentAttendance() {
        viewModel.deleteFormDocument()
        Toast.makeText(requireContext(), "Maaf data anda gagal tersimpan", Toast.LENGTH_SHORT)
            .show()
    }

    private fun getDate(): String = StringHelper.getCurrentDate().toCollectionOrDocumentPath()
    private fun getDay(): String = scheduleModel.day.toEmpty().toCollectionOrDocumentPath()
    private fun getSubject(): String = scheduleModel.subject.toEmpty().toCollectionOrDocumentPath()
    private fun getGrade(): String = scheduleModel.grade.toEmpty().toCollectionOrDocumentPath()
    private fun getStatus(studentModel: StudentModel): String {
        studentNotPresentAdapter.getData().forEach {
            if (it.student == studentModel.name) {
                return it.status.value
            }
        }
        return StudentAttendanceModel.Status.PRESENT.value
    }
}