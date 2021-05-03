package id.bachtiar.harits.studentattendancesystem.feature.report

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentReportBinding
import id.bachtiar.harits.studentattendancesystem.model.firebase.GradeModel
import id.bachtiar.harits.studentattendancesystem.util.Constant

class ReportFragment : Fragment(), GradeAdapter.OnItemGradeClickCallback {

    private lateinit var viewBinding: FragmentReportBinding
    private lateinit var viewModel: ReportViewModel
    private lateinit var gradeAdapter: GradeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReportBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ReportViewModel::class.java)
        viewModel.sharedPreferences = requireActivity().application.getSharedPreferences(
            Constant.Config.APP_PREFERENCE,
            Context.MODE_PRIVATE
        )
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
//        gradeAdapter.setData(DummyReport.data)
        viewModel.getData { data ->
            gradeAdapter.setData(data)
        }
    }

    override fun onItemClicked(data: GradeModel) {
        val toGradeActivity = ReportFragmentDirections.actionNavigationReportToGradeActivity(data)
        findNavController().navigate(toGradeActivity)
    }
}