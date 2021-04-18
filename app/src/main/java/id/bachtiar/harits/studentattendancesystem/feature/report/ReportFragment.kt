package id.bachtiar.harits.studentattendancesystem.feature.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.DummyReport
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentReportBinding
import id.bachtiar.harits.studentattendancesystem.model.Grade

class ReportFragment : Fragment(), GradeAdapter.OnItemGradeClickCallback {

    private lateinit var viewBinding: FragmentReportBinding
    private lateinit var viewModel: ReportViewModel
    private lateinit var gradeAdapter: GradeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReportBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gradeAdapter = GradeAdapter()
        gradeAdapter.setOnItemClickCallback(this)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(viewBinding.rvGrade.context, linearLayoutManager.orientation)
        viewBinding.rvGrade.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = gradeAdapter
            addItemDecoration(dividerItemDecoration)
        }
        gradeAdapter.setData(DummyReport.data)
    }

    override fun onItemClicked(data: Grade) {
        val toGradeActivity = ReportFragmentDirections.actionNavigationReportToGradeActivity(data)
        findNavController().navigate(toGradeActivity)
    }
}