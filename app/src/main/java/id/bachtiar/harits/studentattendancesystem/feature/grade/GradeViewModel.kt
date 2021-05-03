package id.bachtiar.harits.studentattendancesystem.feature.grade

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.base.BaseViewModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel

class GradeViewModel : BaseViewModel() {

    val TAG = "GRADE_VIEW_MODEL"
    private var db = Firebase.firestore

    fun getData(collectionPath: String, onSuccess: (data: List<StudentModel>) -> Unit) {
        handleFirebaseLoading()
        db.collection(collectionPath).get()
            .addOnSuccessListener { result ->
                val data: ArrayList<StudentModel> = arrayListOf()
                result.forEach { document ->
                    val student = document.toObject<StudentModel>()
                    data.add(student)
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