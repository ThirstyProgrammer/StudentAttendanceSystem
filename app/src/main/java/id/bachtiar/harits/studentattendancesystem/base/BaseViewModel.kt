package id.bachtiar.harits.studentattendancesystem.base

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import id.bachtiar.harits.studentattendancesystem.model.Profile
import id.bachtiar.harits.studentattendancesystem.model.firebase.UserModel
import id.bachtiar.harits.studentattendancesystem.util.*
import id.mufid.android.widget.ViewState

abstract class BaseViewModel : ViewModel() {

    val mutableViewState: MutableLiveData<ViewState> = MutableLiveData()
    var user: FirebaseUser? = null

    fun reLogin(sharedPreferences: SharedPreferences) {
        val user = sharedPreferences.getUserProfile()
    }

    fun setupPreferenceAfterSignIn(sharedPreferences: SharedPreferences, userDocument: UserModel) {
        if (user != null) {
            sharedPreferences.setupProfileResults(
                Profile(Constant.EMPTY_STRING).convertToStringJson(
                    user!!,
                    userDocument
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
}