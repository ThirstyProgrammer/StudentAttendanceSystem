package id.bachtiar.harits.studentattendancesystem.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {

    private lateinit var viewBinding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
}