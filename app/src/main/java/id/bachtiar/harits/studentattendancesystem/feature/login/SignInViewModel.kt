package id.bachtiar.harits.studentattendancesystem.feature.login

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.base.BaseViewModel

class SignInViewModel : BaseViewModel() {

    lateinit var sharedPreferences: SharedPreferences
    private var auth: FirebaseAuth = Firebase.auth

    fun signInWithPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ) {
        handleFirebaseLoading()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                setUser(auth)
                setupPreferenceAfterSignIn(sharedPreferences)
                onSuccess()
            } else {
                onFailed()
            }
            handleFirebaseComplete()
        }
    }
}