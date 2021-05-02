package id.bachtiar.harits.studentattendancesystem.feature.student

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel

class StudentViewModel : ViewModel() {

    val TAG = "STUDENT_VIEW_MODEL"
    private var db = Firebase.firestore

    fun getData(collectionPath: String, onSuccess: (data: List<StudentAttendanceModel>) -> Unit) {
        db.collection(collectionPath).get()
            .addOnSuccessListener { result ->
                val data: ArrayList<StudentAttendanceModel> = arrayListOf()
                result.forEach { document ->
                    val studentAttendance = document.toObject<StudentAttendanceModel>()
                    data.add(studentAttendance)
                }
                onSuccess(data)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }
}