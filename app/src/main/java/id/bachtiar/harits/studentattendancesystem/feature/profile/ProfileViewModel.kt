package id.bachtiar.harits.studentattendancesystem.feature.profile

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileViewModel : ViewModel() {

    lateinit var sharedPreferences: SharedPreferences
    private var auth: FirebaseAuth = Firebase.auth

    fun signOut() {
        auth.signOut()
    }
}