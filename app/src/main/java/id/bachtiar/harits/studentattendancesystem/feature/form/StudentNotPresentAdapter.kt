package id.bachtiar.harits.studentattendancesystem.feature.form

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.bachtiar.harits.studentattendancesystem.databinding.ItemStudentNotPresentBinding
import id.bachtiar.harits.studentattendancesystem.model.StudentDialog

class StudentNotPresentAdapter :
    RecyclerView.Adapter<StudentNotPresentAdapter.StudentNotPresentViewHolder>() {

    private var items = ArrayList<StudentDialog>()
    private lateinit var listener: StudentNotPresentAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentNotPresentViewHolder {
        val binding: ItemStudentNotPresentBinding = ItemStudentNotPresentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return StudentNotPresentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentNotPresentViewHolder, position: Int) {
        holder.bind(items[position], ::removeItems)
    }

    override fun getItemCount(): Int = items.size

    fun setListener(studentNotPresentAdapterListener: StudentNotPresentAdapterListener) {
        listener = studentNotPresentAdapterListener
    }

    fun getData(): List<StudentDialog> = items

    fun addData(data: StudentDialog) {
        items.add(data)
        notifyDataSetChanged()
    }

    private fun removeItems(studentNotPresent: StudentDialog) {
        val position = items.indexOf(studentNotPresent)
        items.remove(studentNotPresent)
        notifyItemRemoved(position)
        listener.onItemRemoved(studentNotPresent)
        if (items.isEmpty()) listener.onEmptyList()
    }

    inner class StudentNotPresentViewHolder constructor(private val viewBinding: ItemStudentNotPresentBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(
            studentNotPresent: StudentDialog,
            removeItem: (studentNotPresent: StudentDialog) -> Unit
        ) {
            viewBinding.apply {
                tvName.text = studentNotPresent.student
                tvStatus.text = studentNotPresent.status.value
                btnRemove.setOnClickListener {
                    removeItem(studentNotPresent)
                }
            }
        }
    }
}

interface StudentNotPresentAdapterListener {
    fun onEmptyList()
    fun onItemRemoved(studentNotPresent: StudentDialog)
}