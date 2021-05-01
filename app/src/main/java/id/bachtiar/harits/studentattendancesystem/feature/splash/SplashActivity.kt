package id.bachtiar.harits.studentattendancesystem.feature.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import id.bachtiar.harits.studentattendancesystem.R
import id.bachtiar.harits.studentattendancesystem.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.setGraph(R.navigation.user_navigation, intent.extras)

        if (intent.extras != null) {
            val isGoToSignIn: Boolean =
                SplashActivityArgs.fromBundle(intent.extras as Bundle).isGoToSignIn.toBoolean()
            if (isGoToSignIn) {
                navController.navigate(R.id.signin_fragment)
            }
        }
    }
}