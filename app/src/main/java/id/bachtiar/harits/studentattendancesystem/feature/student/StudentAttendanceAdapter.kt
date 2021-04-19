package id.bachtiar.harits.studentattendancesystem.feature.student

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import id.bachtiar.harits.studentattendancesystem.databinding.ItemStudentAttendanceBinding
import id.bachtiar.harits.studentattendancesystem.model.Attendance
import id.bachtiar.harits.studentattendancesystem.model.StudentAttendance

class StudentAttendanceAdapter :
    RecyclerView.Adapter<StudentAttendanceAdapter.StudentAttendanceViewHolder>() {

    private var studentAttendance = ArrayList<StudentAttendance>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAttendanceViewHolder {
        val binding: ItemStudentAttendanceBinding = ItemStudentAttendanceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return StudentAttendanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentAttendanceViewHolder, position: Int) {
        holder.bind(studentAttendance[position])
    }

    override fun getItemCount(): Int = studentAttendance.size

    fun setData(data: List<StudentAttendance>) {
        studentAttendance.clear()
        studentAttendance.addAll(data)
        notifyDataSetChanged()
    }

    inner class StudentAttendanceViewHolder constructor(private val viewBinding: ItemStudentAttendanceBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(attendance: StudentAttendance) {
            viewBinding.apply {
                tvName.text = attendance.schedule.subjects
                tvStatus.text = Attendance.Status.getValue(attendance.status)
                tvIntervalHour.text =
                    "${attendance.schedule.startTime} - ${attendance.schedule.endTime}"
                tvDate.text = "${attendance.schedule.day}, ${attendance.date}"
                containerMain.setBackgroundColor(
                    ContextCompat.getColor(
                        viewBinding.root.context,
                        attendance.getContainerColor()
                    )
                )
            }
        }
    }
}