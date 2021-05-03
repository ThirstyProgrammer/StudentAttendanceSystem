package id.bachtiar.harits.studentattendancesystem.feature.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import id.bachtiar.harits.studentattendancesystem.R
import id.bachtiar.harits.studentattendancesystem.databinding.DialogStudentNotPresentBinding
import id.bachtiar.harits.studentattendancesystem.model.StudentDialog
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel
import id.bachtiar.harits.studentattendancesystem.util.toDash

class DialogStudentNotPresent : DialogFragment() {

    private lateinit var viewBinding: DialogStudentNotPresentBinding
    private lateinit var listener: DialogListener
    var studentItems: ArrayList<String> = arrayListOf()

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
                    student = spStudent.selectedItem.toString(),
                    status = StudentAttendanceModel.Status.getEnum(spStatus.selectedItem.toString()),
                    information = etInformation.text.toString()
                )
                studentItems.remove(spStudent.selectedItem)
                listener.onButtonPositiveClicked(studentDialog)
                dialog?.dismiss()
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