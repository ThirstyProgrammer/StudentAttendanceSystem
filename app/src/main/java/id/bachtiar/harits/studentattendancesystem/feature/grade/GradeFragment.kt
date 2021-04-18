package id.bachtiar.harits.studentattendancesystem.feature.grade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentGradeBinding
import id.bachtiar.harits.studentattendancesystem.model.Grade
import id.bachtiar.harits.studentattendancesystem.model.Student

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
            tvName.text = grade.name
            tvHomeroomTeacher.text = grade.homeroomTeacher
            tvTotalStudent.text = grade.getTotalStudents()

            val linearLayoutManager = LinearLayoutManager(requireContext())
            val dividerItemDecoration =
                DividerItemDecoration(rvGrade.context, linearLayoutManager.orientation)
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