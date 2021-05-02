package id.bachtiar.harits.studentattendancesystem.feature.grade

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel

class GradeViewModel : ViewModel() {

    val TAG = "GRADE_VIEW_MODEL"
    private var db = Firebase.firestore

    fun getData(collectionPath: String, onSuccess: (data: List<StudentModel>) -> Unit) {
        db.collection(collectionPath).get()
            .addOnSuccessListener { result ->
                val data: ArrayList<StudentModel> = arrayListOf()
                result.forEach { document ->
                    val student = document.toObject<StudentModel>()
                    data.add(student)
                }
                onSuccess(data)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }
}