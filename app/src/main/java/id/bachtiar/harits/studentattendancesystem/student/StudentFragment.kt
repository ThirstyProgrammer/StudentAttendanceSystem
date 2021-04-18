package id.bachtiar.harits.studentattendancesystem.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentStudentBinding

class StudentFragment : Fragment() {

    private lateinit var viewBinding: FragmentStudentBinding
    private lateinit var viewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentStudentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
}