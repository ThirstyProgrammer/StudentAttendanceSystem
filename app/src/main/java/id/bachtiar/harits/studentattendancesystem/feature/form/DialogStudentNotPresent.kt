package id.bachtiar.harits.studentattendancesystem.feature.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import id.bachtiar.harits.studentattendancesystem.R
import id.bachtiar.harits.studentattendancesystem.databinding.DialogStudentNotPresentBinding
import id.bachtiar.harits.studentattendancesystem.model.Attendance
import id.bachtiar.harits.studentattendancesystem.model.StudentDialog

class DialogStudentNotPresent : DialogFragment() {

    private lateinit var viewBinding: DialogStudentNotPresentBinding
    private lateinit var listener: DialogListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.bg_round_corner
            )
        )
        viewBinding = DialogStudentNotPresentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            val studentItems = ArrayList<String>()
            studentItems.add("HELLO1")
            studentItems.add("HELLO2")
            studentItems.add("HELLO3")
            studentItems.add("HELL4")
            studentItems.add("HELL5")
            studentItems.add("HEL5LO")
            studentItems.add("HELL6O")
            studentItems.add("HELLO7")
            studentItems.add("8HELLO")
            studentItems.add("H8ELLO")

            studentItems.add("HE8LLO")
            studentItems.add("HEL9LO")
            studentItems.add("HELL0O")
            studentItems.add("HELLO-0")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")

            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")

            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")
            studentItems.add("HELLO")

            studentItems.add("HELLOLAST")
            spStudent.adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, studentItems)
            val spinnerItems = ArrayList<String>()
            spinnerItems.add("Sakit")
            spinnerItems.add("Izin")
            spinnerItems.add("Alpa")
            spStatus.adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, spinnerItems)
            btnNegative.setOnClickListener {
                dialog?.dismiss()
            }
            btnPositive.setOnClickListener {
                val studentDialog = StudentDialog(
                    student = "User Test",
                    status = Attendance.Status.getEnum(spStatus.selectedItem.toString()),
                    information = etInformation.text.toString()
                )
                listener.onButtonPositiveClicked(studentDialog)
            }
        }
    }


    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setupListener(dialogListener: DialogListener) {
        listener = dialogListener
    }
}

interface DialogListener {
    fun onButtonPositiveClicked(studentDialog: StudentDialog)
}