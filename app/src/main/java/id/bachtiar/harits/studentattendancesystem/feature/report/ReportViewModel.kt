package id.bachtiar.harits.studentattendancesystem.feature.report

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.model.firebase.GradeModel
import id.bachtiar.harits.studentattendancesystem.util.getUserProfile

class ReportViewModel : ViewModel() {

    lateinit var sharedPreferences: SharedPreferences

    val TAG = "REPORT_VIEW_MODEL"
    private var db = Firebase.firestore
    private val gradeCollection = db.collection("KELAS")

    fun getData(onSuccess: (data: ArrayList<GradeModel>) -> Unit) {
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
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    private fun getListGrade(): List<String> = sharedPreferences.getUserProfile().grades.split(", ")
}