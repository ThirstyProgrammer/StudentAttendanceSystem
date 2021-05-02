package id.bachtiar.harits.studentattendancesystem.feature.form

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
import id.bachtiar.harits.studentattendancesystem.util.StringHelper
import id.bachtiar.harits.studentattendancesystem.util.setViewVisibility
import id.bachtiar.harits.studentattendancesystem.util.toEmpty
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
//                generateFormData()
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

    private fun getStudents(grade: String) {
        val collectionPath = grade.replace("\\s".toRegex(), "").toUpperCase(Locale.ROOT)
        viewModel.getStudentByClass(collectionPath) { data ->
            dialog.students = data
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
        val documentPath = "${getTrimSubject()}-${getTrimGrade()}-${getTrimDate()}"
        viewModel.createFormDocument(
            documentPath,
            formData,
            ::onSuccessCreateForm,
            ::onFailedCreateForm
        )
    }

    private fun onSuccessCreateForm() {
        // TODO Update Collection Class
        viewModel.updateClass(getTrimGrade(), ::onSuccessUpdateClass, ::onFailedUpdateClass)
        // TODO Update Collection Per User
        // TODO Update Schedule Last Updated
    }

    private fun onFailedCreateForm() {
        Toast.makeText(requireContext(), "Maaf data anda gagal tersimpan", Toast.LENGTH_SHORT)
            .show()
    }

    private fun onSuccessUpdateClass() {
        // TODO HANDLE
    }

    private fun onFailedUpdateClass() {
        // TODO HANDLE
    }

    private fun onSuccess() {
        Toast.makeText(requireContext(), "DATA INSERTED", Toast.LENGTH_SHORT).show()
    }

    private fun getTrimDate(): String {
        return StringHelper.getCurrentDate().replace("\\s".toRegex(), "").toUpperCase(Locale.ROOT)
    }

    private fun getTrimSubject(): String {
        return scheduleModel.subject.toEmpty().replace("\\s".toRegex(), "").toUpperCase(
            Locale.ROOT
        )
    }

    private fun getTrimGrade(): String {
        return scheduleModel.grade.toEmpty().replace("\\s".toRegex(), "").toUpperCase(
            Locale.ROOT
        )
    }
}