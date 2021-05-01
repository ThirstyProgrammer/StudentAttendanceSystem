package id.bachtiar.harits.studentattendancesystem.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.bachtiar.harits.studentattendancesystem.DummyHome
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentHomeBinding
import id.bachtiar.harits.studentattendancesystem.model.Schedule

class HomeFragment : Fragment(), ScheduleAdapter.OnItemScheduleClickCallback {

    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
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
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        scheduleAdapter.setData(DummyHome.data)
        viewModel.getData()
    }

    override fun onItemClicked(data: Schedule) {
        val toFormActivity = HomeFragmentDirections.actionNavigationHomeToFormActivity(data)
        findNavController().navigate(toFormActivity)
    }
}