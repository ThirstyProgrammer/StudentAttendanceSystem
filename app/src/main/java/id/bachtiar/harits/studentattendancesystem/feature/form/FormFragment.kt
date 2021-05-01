package id.bachtiar.harits.studentattendancesystem.feature.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentFormBinding
import id.bachtiar.harits.studentattendancesystem.model.Schedule
import id.bachtiar.harits.studentattendancesystem.model.StudentDialog

class FormFragment : Fragment(), DialogListener {

    private lateinit var viewBinding: FragmentFormBinding
    private lateinit var dialog: DialogStudentNotPresent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFormBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val schedule: Schedule = FormFragmentArgs.fromBundle(arguments as Bundle).schedule
        viewBinding.apply {
            tvName.text = schedule.subjects
            tvGrade.text = schedule.grade
            tvIntervalHour.text =
                "${schedule.startTime} - ${schedule.endTime}"
            tvDate.text = "${schedule.day}, 18 April 2021"
            btnBack.setOnClickListener {
                requireActivity().finish()
            }
            btnAddStudentNotPresent.setOnClickListener {
                dialog = DialogStudentNotPresent()
                dialog.show(parentFragmentManager, "STUDENT NOT PRESENT")
                dialog.setupListener(this@FormFragment)
            }
        }
    }

    override fun onButtonPositiveClicked(studentDialog: StudentDialog) {
        Toast.makeText(
            requireContext(),
            "POSITIVE ${studentDialog.information} ${studentDialog.status}",
            Toast.LENGTH_SHORT
        ).show()
    }
}