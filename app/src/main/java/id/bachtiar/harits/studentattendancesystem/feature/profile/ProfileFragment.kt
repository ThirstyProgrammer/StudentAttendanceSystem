package id.bachtiar.harits.studentattendancesystem.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.bachtiar.harits.studentattendancesystem.BuildConfig
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var viewBinding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProfileViewModel::class.java)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            tvName.text = "Eny Purwaningsih, S.Pd"
            tvGrade.text = "X IPA 1"
            tvSubjects.text = "Matematika, Fisika"
            tvVersion.text = "StudentAttendanceSystem V.${BuildConfig.VERSION_NAME}"
            btnSignOut.setOnClickListener {
                viewModel.signOut()
                val directions = ProfileFragmentDirections.actionNavigationProfileToSplashActivity()
                directions.isGoToSignIn = "true"
                findNavController().navigate(directions)
            }
        }
    }
}