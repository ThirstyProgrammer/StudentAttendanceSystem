package id.bachtiar.harits.studentattendancesystem.grade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentGradeBinding
import id.bachtiar.harits.studentattendancesystem.model.Grade
import id.bachtiar.harits.studentattendancesystem.model.Student
import id.bachtiar.harits.studentattendancesystem.report.ReportFragmentDirections
import id.bachtiar.harits.studentattendancesystem.util.AppBarStateChangeListener

class GradeFragment : Fragment(), StudentReportAdapter.OnItemStudentReportClickCallback {

    private lateinit var viewBinding: FragmentGradeBinding
    private lateinit var studentReportAdapter: StudentReportAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentGradeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val grade: Grade = GradeFragmentArgs.fromBundle(arguments as Bundle).grade
        studentReportAdapter = StudentReportAdapter()
        studentReportAdapter.setOnItemClickCallback(this)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(viewBinding.rvGrade.context, linearLayoutManager.orientation)
        viewBinding.apply {
//            appBar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
//                override fun onStateChanged(appBarLayout: AppBarLayout?, state: State) {
//                    when (state) {
//                        State.EXPANDED -> viewBinding.toolbar.visibility = View.INVISIBLE
//                        State.COLLAPSED -> viewBinding.toolbar.visibility = View.VISIBLE
//                        else -> viewBinding.toolbar.visibility = View.GONE
//                    }
//                }
//            })
            toolbar.title = grade.name
            tvName.text = grade.name
            tvHomeroomTeacher.text = grade.homeroomTeacher
            tvTotalStudent.text = "${grade.getTotalStudents()} Siswa"

            rvGrade.apply {
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
                adapter = studentReportAdapter
                addItemDecoration(dividerItemDecoration)
            }
            studentReportAdapter.setData(grade.students)
        }
    }

    override fun onItemClicked(data: Student) {
        val toStudentFragment = GradeFragmentDirections.actionGradeFragmentToStudentFragment(data)
        findNavController().navigate(toStudentFragment)
    }
}