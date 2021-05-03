package id.bachtiar.harits.studentattendancesystem.feature.home

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.DummyReport
import id.bachtiar.harits.studentattendancesystem.model.firebase.ScheduleModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.UserModel
import id.bachtiar.harits.studentattendancesystem.util.StringHelper
import id.bachtiar.harits.studentattendancesystem.util.getUserProfile
import java.util.*
import kotlin.collections.ArrayList

class HomeViewModel : ViewModel() {

    lateinit var sharedPreferences: SharedPreferences

    val TAG = "HOME_VIEW_MODEL"
    private var db = Firebase.firestore

    fun getSchedule(collectionPath: String, onSuccess: (data: ArrayList<ScheduleModel>) -> Unit) {
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
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }
}