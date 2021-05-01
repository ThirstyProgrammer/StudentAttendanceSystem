package id.bachtiar.harits.studentattendancesystem.base

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import id.bachtiar.harits.studentattendancesystem.model.Profile
import id.bachtiar.harits.studentattendancesystem.util.*
import id.mufid.android.widget.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    val uiScope = (CoroutineScope(Dispatchers.Main + viewModelJob))

    val mutableViewState: MutableLiveData<ViewState> = MutableLiveData()
    var user: FirebaseUser? = null

    fun reLogin(sharedPreferences: SharedPreferences) {
        val user = sharedPreferences.getUserProfile()
    }

    fun setupPreferenceAfterSignIn(sharedPreferences: SharedPreferences) {
        if (user != null) {
            sharedPreferences.setupProfileResults(
                Profile(Constant.EMPTY_STRING).convertToStringJson(
                    user!!
                )
            )
            user!!.getIdToken(true).addOnCompleteListener {
                sharedPreferences.setToken(it.result?.token ?: Constant.EMPTY_STRING)
            }
            sharedPreferences.pushBoolean(Constant.Preference.IS_USER_LOGIN, true)
        }
    }

    fun handleFirebaseComplete() {
        val viewState = ViewState()
        viewState.stateStatus = ViewState.Status.GONE
        mutableViewState.value = viewState
    }

    fun handleFirebaseLoading() {
        val viewState = ViewState()
        viewState.stateStatus = ViewState.Status.PROGRESSING
        mutableViewState.value = viewState
    }

    fun setUser(firebaseAuth: FirebaseAuth) {
        val user = firebaseAuth.currentUser
        if (user != null) {
            this.user = user
        }
    }

    fun isEmailVerified(): Boolean = user?.isEmailVerified ?: false

    fun reloadOnComplete(
        firebaseAuth: FirebaseAuth,
        sharedPreferences: SharedPreferences,
        onComplete: () -> Unit
    ) {
        reloadOnEmailVerified(firebaseAuth, sharedPreferences, onComplete, onComplete, onComplete)
    }

    fun reloadOnEmailVerified(
        firebaseAuth: FirebaseAuth,
        sharedPreferences: SharedPreferences,
        onEmailVerified: () -> Unit,
        onEmailNotVerified: () -> Unit,
        onUserNotLogin: () -> Unit
    ) {
        handleFirebaseLoading()
        setUser(firebaseAuth)
        if (user != null) {
            user!!.reload().addOnCompleteListener {
                if (user!!.isEmailVerified) {
                    setupPreferenceAfterSignIn(sharedPreferences)
                    onEmailVerified()
                } else {
                    onEmailNotVerified()
                }
                handleFirebaseComplete()
            }
        } else {
            onUserNotLogin()
            handleFirebaseComplete()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}