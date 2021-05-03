package id.bachtiar.harits.studentattendancesystem.feature.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.bachtiar.harits.studentattendancesystem.BuildConfig
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentProfileBinding
import id.bachtiar.harits.studentattendancesystem.util.Constant
import id.bachtiar.harits.studentattendancesystem.util.getUserProfile

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
        viewModel.sharedPreferences = requireActivity().application.getSharedPreferences(
            Constant.Config.APP_PREFERENCE,
            Context.MODE_PRIVATE
        )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            val profile = viewModel.sharedPreferences.getUserProfile()
            tvName.text = profile.username
            tvGrade.text = profile.grades
            tvSubjects.text = profile.subjects
            tvVersion.text = "Simon V.${BuildConfig.VERSION_NAME}"
            btnSignOut.setOnClickListener {
                viewModel.signOut()
                val directions = ProfileFragmentDirections.actionNavigationProfileToSplashActivity()
                directions.isGoToSignIn = "true"
                findNavController().navigate(directions)
            }
        }
    }
}