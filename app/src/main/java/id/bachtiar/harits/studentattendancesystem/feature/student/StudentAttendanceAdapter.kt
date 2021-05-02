package id.bachtiar.harits.studentattendancesystem.feature.student

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import id.bachtiar.harits.studentattendancesystem.databinding.ItemStudentAttendanceBinding
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel

class StudentAttendanceAdapter :
    RecyclerView.Adapter<StudentAttendanceAdapter.StudentAttendanceViewHolder>() {

    private var studentAttendance = ArrayList<StudentAttendanceModel>()

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

    fun setData(data: List<StudentAttendanceModel>) {
        studentAttendance.clear()
        studentAttendance.addAll(data)
        notifyDataSetChanged()
    }

    inner class StudentAttendanceViewHolder constructor(private val viewBinding: ItemStudentAttendanceBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(attendance: StudentAttendanceModel) {
            viewBinding.apply {
                tvName.text = attendance.subject
                tvStatus.text = attendance.status
                tvIntervalHour.text =
                    "${attendance.startTime} - ${attendance.endTime}"
                tvDate.text = attendance.date
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