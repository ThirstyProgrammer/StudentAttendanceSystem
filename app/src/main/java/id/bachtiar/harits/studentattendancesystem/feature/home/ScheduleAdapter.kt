package id.bachtiar.harits.studentattendancesystem.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.bachtiar.harits.studentattendancesystem.databinding.ItemSchedulesBinding
import id.bachtiar.harits.studentattendancesystem.model.Attendance
import id.bachtiar.harits.studentattendancesystem.model.Schedule

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    private lateinit var listener: OnItemScheduleClickCallback
    private var schedules = ArrayList<Schedule>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding: ItemSchedulesBinding =
            ItemSchedulesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(schedules[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(schedules[position])
        }
    }

    override fun getItemCount(): Int = schedules.size

    fun setOnItemClickCallback(onItemScheduleClickCallback: OnItemScheduleClickCallback) {
        this.listener = onItemScheduleClickCallback
    }

    fun setData(data: List<Schedule>) {
        schedules.clear()
        schedules.addAll(data)
        notifyDataSetChanged()
    }

    inner class ScheduleViewHolder constructor(private val viewBinding: ItemSchedulesBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(schedule: Schedule) {
            viewBinding.apply {
                tvName.text = schedule.subjects
                tvGrade.text = schedule.grade
                tvIntervalHour.text =
                    "${schedule.startTime} - ${schedule.endTime}"
                tvDate.text = "${schedule.day}, 18 April 2021"
            }
        }
    }

    interface OnItemScheduleClickCallback {
        fun onItemClicked(data: Schedule)
    }
}