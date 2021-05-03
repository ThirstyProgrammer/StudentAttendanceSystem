package id.bachtiar.harits.studentattendancesystem.feature.login

import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.base.BaseViewModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.UserModel
import id.bachtiar.harits.studentattendancesystem.util.getUserProfile
import id.bachtiar.harits.studentattendancesystem.util.toEmpty
import java.util.*

class SignInViewModel : BaseViewModel() {

    lateinit var sharedPreferences: SharedPreferences

    private val TAG = "SIGNIN_VIEW_MODEL"
    private var db = Firebase.firestore
    private var auth: FirebaseAuth = Firebase.auth
    private val usersCollection = db.collection("USERS")

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
                getUserData(onSuccess)
            } else {
                onFailed()
            }
            handleFirebaseComplete()
        }
    }

    private fun getUserData(onSuccess: () -> Unit) {
        usersCollection.get()
            .addOnSuccessListener { result ->
                result.forEach { document ->
                    val userDocument = document.toObject<UserModel>()
                    if (userDocument.email == user?.email) {
                        setupPreferenceAfterSignIn(sharedPreferences, userDocument)
                        onSuccess()
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }
}