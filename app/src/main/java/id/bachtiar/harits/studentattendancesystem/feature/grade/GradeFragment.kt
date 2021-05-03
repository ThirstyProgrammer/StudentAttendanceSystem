package id.bachtiar.harits.studentattendancesystem.feature.grade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.base.BaseFragment
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentGradeBinding
import id.bachtiar.harits.studentattendancesystem.model.firebase.GradeModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel
import id.bachtiar.harits.studentattendancesystem.util.toCollectionOrDocumentPath
import id.bachtiar.harits.studentattendancesystem.widget.ViewState
import java.util.*

class GradeFragment : BaseFragment<GradeViewModel>(),
    StudentReportAdapter.OnItemStudentReportClickCallback, ViewState.RetryRequest {

    private lateinit var viewBinding: FragmentGradeBinding
    private lateinit var studentReportAdapter: StudentReportAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentGradeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(GradeViewModel::class.java)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handlingViewState(viewBinding.containerMain, viewBinding.viewState, this)

        val grade: GradeModel = GradeFragmentArgs.fromBundle(arguments as Bundle).grade
        studentReportAdapter = StudentReportAdapter()
        studentReportAdapter.setOnItemClickCallback(this)
        viewBinding.apply {
            tvName.text = grade.name
            tvHomeroomTeacher.text = grade.homeroomTeacher
            tvTotalStudent.text = grade.students.toString()

            val linearLayoutManager = LinearLayoutManager(requireContext())
            val dividerItemDecoration =
                DividerItemDecoration(rvGrade.context, linearLayoutManager.orientation)
            rvGrade.apply {
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
                adapter = studentReportAdapter
                addItemDecoration(dividerItemDecoration)
            }
            btnBack.setOnClickListener {
                requireActivity().finish()
            }
            getData(grade.name.toString())
        }
    }

    override fun onItemClicked(data: StudentModel) {
        val toStudentFragment = GradeFragmentDirections.actionGradeFragmentToStudentFragment(data)
        findNavController().navigate(toStudentFragment)
    }

    override fun retry(response: ViewState.ResponseType) {}
    override fun handleUnAuthorized() {}
    override fun handleFailedRequest(message: String, respone: ViewState.ResponseType) {}

    private fun getData(gradeName: String) {
        val collectionPath = gradeName.toCollectionOrDocumentPath()
        viewModel.getData(collectionPath) { data ->
            studentReportAdapter.setData(data)
        }
    }
}