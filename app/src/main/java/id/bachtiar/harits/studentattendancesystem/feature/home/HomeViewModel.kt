package id.bachtiar.harits.studentattendancesystem.feature.home

import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.base.BaseViewModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.ScheduleModel
import id.bachtiar.harits.studentattendancesystem.util.StringHelper

class HomeViewModel : BaseViewModel() {

    lateinit var sharedPreferences: SharedPreferences

    val TAG = "HOME_VIEW_MODEL"
    private var db = Firebase.firestore

    fun getSchedule(collectionPath: String, onSuccess: (data: ArrayList<ScheduleModel>) -> Unit) {
        handleFirebaseLoading()
        db.collection(collectionPath)
            .whereEqualTo("day", StringHelper.getCurrentDay())
            .get()
            .addOnSuccessListener { result ->
                val data: ArrayList<ScheduleModel> = arrayListOf()
                result.forEach { document ->
                    val schedule = document.toObject<ScheduleModel>()
                    data.add(schedule)
                }
                onSuccess(data)
                handleFirebaseComplete()
            }
            .addOnFailureListener { exception ->
                handleFirebaseComplete()
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }
}