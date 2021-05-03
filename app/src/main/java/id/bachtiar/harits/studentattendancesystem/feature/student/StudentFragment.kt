package id.bachtiar.harits.studentattendancesystem.feature.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.base.BaseFragment
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentStudentBinding
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel
import id.bachtiar.harits.studentattendancesystem.util.setViewVisibility
import id.bachtiar.harits.studentattendancesystem.widget.ViewState
import java.util.*

class StudentFragment : BaseFragment<StudentViewModel>(), ViewState.RetryRequest {

    private lateinit var viewBinding: FragmentStudentBinding
    private lateinit var studentAttendanceAdapter: StudentAttendanceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentStudentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(StudentViewModel::class.java)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handlingViewState(viewBinding.containerMain, viewBinding.viewState, this)
        val student: StudentModel = StudentFragmentArgs.fromBundle(arguments as Bundle).student
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
            btnBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
            getData(student.name.toString())
        }
    }

    override fun retry(response: ViewState.ResponseType) {}
    override fun handleUnAuthorized() {}
    override fun handleFailedRequest(message: String, respone: ViewState.ResponseType) {}

    private fun getData(studentName: String) {
        val collectionPath = studentName.replace("\\s".toRegex(), "").toUpperCase(Locale.ROOT)
        viewModel.getData(collectionPath) { data ->
            viewBinding.apply {
                tvEmptyAttendance.setViewVisibility(data.isEmpty())
                rvAttendance.setViewVisibility(data.isNotEmpty())
            }
            studentAttendanceAdapter.setData(data)
        }

    }
}