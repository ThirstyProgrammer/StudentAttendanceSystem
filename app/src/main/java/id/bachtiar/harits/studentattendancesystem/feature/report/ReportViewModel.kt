package id.bachtiar.harits.studentattendancesystem.feature.report

import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.base.BaseViewModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.GradeModel
import id.bachtiar.harits.studentattendancesystem.util.getUserProfile

class ReportViewModel : BaseViewModel() {

    lateinit var sharedPreferences: SharedPreferences

    val TAG = "REPORT_VIEW_MODEL"
    private var db = Firebase.firestore
    private val gradeCollection = db.collection("KELAS")

    fun getData(onSuccess: (data: ArrayList<GradeModel>) -> Unit) {
        handleFirebaseLoading()
        if (sharedPreferences.getUserProfile().role == "kesiswaan") {
            getDataForAdmin(onSuccess)
        } else {
            getDataForTeacher(onSuccess)
        }
    }

    private fun getDataForTeacher(onSuccess: (data: ArrayList<GradeModel>) -> Unit) {
        val listGrade = getListGrade()
        gradeCollection
            .whereIn("name", listGrade)
            .get()
            .addOnSuccessListener { result ->
                val data: ArrayList<GradeModel> = arrayListOf()
                result.forEach { document ->
                    val grade = document.toObject<GradeModel>()
                    data.add(grade)
                }
                onSuccess(data)
                handleFirebaseComplete()
            }
            .addOnFailureListener { exception ->
                handleFirebaseComplete()
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    private fun getDataForAdmin(onSuccess: (data: ArrayList<GradeModel>) -> Unit) {
        gradeCollection
            .get()
            .addOnSuccessListener { result ->
                val data: ArrayList<GradeModel> = arrayListOf()
                result.forEach { document ->
                    val grade = document.toObject<GradeModel>()
                    data.add(grade)
                }
                onSuccess(data)
                handleFirebaseComplete()
            }
            .addOnFailureListener { exception ->
                handleFirebaseComplete()
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    private fun getListGrade(): List<String> = sharedPreferences.getUserProfile().grades.split(", ")
}