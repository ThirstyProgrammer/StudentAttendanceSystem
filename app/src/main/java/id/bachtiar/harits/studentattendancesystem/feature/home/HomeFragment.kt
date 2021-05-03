package id.bachtiar.harits.studentattendancesystem.feature.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.base.BaseFragment
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentHomeBinding
import id.bachtiar.harits.studentattendancesystem.model.firebase.ScheduleModel
import id.bachtiar.harits.studentattendancesystem.util.Constant
import id.bachtiar.harits.studentattendancesystem.util.getUserName
import id.bachtiar.harits.studentattendancesystem.util.toCollectionOrDocumentPath
import id.bachtiar.harits.studentattendancesystem.widget.ViewState

class HomeFragment : BaseFragment<HomeViewModel>(), ScheduleAdapter.OnItemScheduleClickCallback,
    ViewState.RetryRequest {

    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var scheduleAdapter: ScheduleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(HomeViewModel::class.java)
        viewModel.sharedPreferences = requireActivity().application.getSharedPreferences(
            Constant.Config.APP_PREFERENCE,
            Context.MODE_PRIVATE
        )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handlingViewState(viewBinding.containerMain, viewBinding.viewState, this)
        scheduleAdapter = ScheduleAdapter()
        scheduleAdapter.setOnItemClickCallback(this)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        val dividerItemDecoration =
            DividerItemDecoration(viewBinding.rvSchedule.context, linearLayoutManager.orientation)
        viewBinding.rvSchedule.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = scheduleAdapter
            addItemDecoration(dividerItemDecoration)
        }
        getSchedule()
    }

    override fun onItemClicked(data: ScheduleModel) {
        val toFormActivity = HomeFragmentDirections.actionNavigationHomeToFormActivity(data)
        findNavController().navigate(toFormActivity)
    }

    override fun retry(response: ViewState.ResponseType) {
        getSchedule()
    }

    override fun handleUnAuthorized() {}
    override fun handleFailedRequest(message: String, respone: ViewState.ResponseType) {}

    private fun getSchedule() {
        viewModel.getSchedule(
            viewModel.sharedPreferences.getUserName().toCollectionOrDocumentPath()
        ) { schedules ->
            scheduleAdapter.setData(schedules)
        }
    }
}