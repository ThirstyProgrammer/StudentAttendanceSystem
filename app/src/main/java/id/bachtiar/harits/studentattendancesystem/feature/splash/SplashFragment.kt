package id.bachtiar.harits.studentattendancesystem.feature.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.R
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentSplashBinding
import java.util.*
import kotlin.concurrent.schedule

class SplashFragment : Fragment() {

    private lateinit var viewBinding: FragmentSplashBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSplashBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        viewBinding.tvAppVersion.text = getString(R.string.app_version)
        Timer().schedule(2000) {
            val directions = if (currentUser != null) {
                SplashFragmentDirections.actionSplashFragmentToMainActivity()
            } else {
                SplashFragmentDirections.actionSplashFragmentToSigninFragment()
            }
            findNavController().navigate(directions)
        }
    }
}