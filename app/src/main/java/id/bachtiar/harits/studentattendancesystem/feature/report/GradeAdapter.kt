package id.bachtiar.harits.studentattendancesystem.feature.report

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.bachtiar.harits.studentattendancesystem.databinding.ItemGradeBinding
import id.bachtiar.harits.studentattendancesystem.model.firebase.GradeModel

class GradeAdapter : RecyclerView.Adapter<GradeAdapter.GradeViewHolder>() {

    private lateinit var listener: OnItemGradeClickCallback
    private var grades = ArrayList<GradeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeViewHolder {
        val binding: ItemGradeBinding =
            ItemGradeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GradeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GradeViewHolder, position: Int) {
        holder.bind(grades[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(grades[position])
        }
    }

    override fun getItemCount(): Int = grades.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemGradeClickCallback) {
        this.listener = onItemClickCallback
    }

    fun setData(data: List<GradeModel>) {
        grades.clear()
        grades.addAll(data)
        notifyDataSetChanged()
    }

    inner class GradeViewHolder constructor(private val viewBinding: ItemGradeBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(grade: GradeModel) {
            viewBinding.apply {
                tvName.text = grade.name
                tvHomeroomTeacher.text = grade.homeroomTeacher
                tvTotalStudent.text = grade.students.toString()
            }
        }
    }

    interface OnItemGradeClickCallback {
        fun onItemClicked(data: GradeModel)
    }
}