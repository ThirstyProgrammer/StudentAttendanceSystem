package id.bachtiar.harits.studentattendancesystem.feature.grade

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.bachtiar.harits.studentattendancesystem.databinding.ItemStudentReportBinding
import id.bachtiar.harits.studentattendancesystem.model.Student

class StudentReportAdapter : RecyclerView.Adapter<StudentReportAdapter.StudentReportViewHolder>() {

    private lateinit var listener: OnItemStudentReportClickCallback
    private var students = ArrayList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentReportViewHolder {
        val binding: ItemStudentReportBinding =
            ItemStudentReportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentReportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentReportViewHolder, position: Int) {
        holder.bind(students[position], listener)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(students[position])
        }
    }

    override fun getItemCount(): Int = students.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemStudentReportClickCallback) {
        this.listener = onItemClickCallback
    }

    fun setData(data: List<Student>) {
        students.clear()
        students.addAll(data)
        notifyDataSetChanged()
    }

    inner class StudentReportViewHolder constructor(private val viewBinding: ItemStudentReportBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(student: Student, listener: OnItemStudentReportClickCallback) {
            viewBinding.apply {
                tvName.text = student.name
                tvPresent.text = "Hadir\n${student.getTotalSick()}\nMapel"
                tvSick.text = "Sakit\n${student.getTotalSick()}\nMapel"
                tvPermit.text = "Izin\n${student.getTotalPermit()}\nMapel"
                tvNeglect.text = "Alpa\n${student.getTotalNeglect()}\nMapel"
                tvPresent.setOnClickListener {
                    listener.onItemClicked(student)
                }
                tvSick.setOnClickListener {
                    listener.onItemClicked(student)
                }
                tvPermit.setOnClickListener {
                    listener.onItemClicked(student)
                }
                tvNeglect.setOnClickListener {
                    listener.onItemClicked(student)
                }
            }
        }
    }

    interface OnItemStudentReportClickCallback {
        fun onItemClicked(data: Student)
    }
}