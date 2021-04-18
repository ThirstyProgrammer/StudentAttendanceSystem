package id.bachtiar.harits.studentattendancesystem.feature.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentStudentBinding
import id.bachtiar.harits.studentattendancesystem.model.Student

class StudentFragment : Fragment() {

    private lateinit var viewBinding: FragmentStudentBinding
    private lateinit var viewModel: StudentViewModel
    private lateinit var studentAttendanceAdapter: StudentAttendanceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentStudentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val student: Student = StudentFragmentArgs.fromBundle(arguments as Bundle).student
        studentAttendanceAdapter = StudentAttendanceAdapter()

        viewBinding.apply {
            val linearLayoutManager = LinearLayoutManager(requireContext())
            val dividerItemDecoration =
                DividerItemDecoration(rvAttendance.context, linearLayoutManager.orientation)
            tvName.text = student.name
            rvAttendance.apply {
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
                adapter = studentAttendanceAdapter
                addItemDecoration(dividerItemDecoration)
            }
            studentAttendanceAdapter.setData(student.attendance)
        }
    }
}