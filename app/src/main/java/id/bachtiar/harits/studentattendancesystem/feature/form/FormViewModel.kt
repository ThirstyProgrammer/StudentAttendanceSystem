package id.bachtiar.harits.studentattendancesystem.feature.form

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.model.AttendanceForm
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel
import id.bachtiar.harits.studentattendancesystem.util.toEmpty
import java.util.*
import kotlin.collections.ArrayList

class FormViewModel : ViewModel() {

    val TAG = "FORM_VIEW_MODEL"
    var students: List<StudentModel> = arrayListOf()
    private var db = Firebase.firestore
    private var formCollection = db.collection("FORM")

//    fun submitData(name: String, teacher: String, onSuccess: () -> Unit) {
//        val data = hashMapOf(
//            "name" to name,
//            "homeroomTeacher" to teacher
//        )
//
////        val list = arrayListOf<HashMap<String, Any>>()
//
//        db.collection("KELAS")
//            .add(data)
//            .addOnSuccessListener { documentReference ->
//                onSuccess
//                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//            }
//            .addOnFailureListener { e ->
//                Log.w(TAG, "Error adding document", e)
//            }
//    }

    fun getStudentByClass(collectionPath: String, onSuccess: (data: List<StudentModel>) -> Unit) {
        db.collection(collectionPath).get()
            .addOnSuccessListener { result ->
                val data: ArrayList<StudentModel> = arrayListOf()
                result.forEach { document ->
                    val student = document.toObject<StudentModel>()
                    data.add(student)
                }
                students = data
                onSuccess(data)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    fun createFormDocument(
        documentPath: String,
        formData: AttendanceForm,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ) {
        formCollection.document(documentPath).set(formData)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onFailed()
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    fun updateClass(collectionPath: String, onSuccess: () -> Unit, onFailed: () -> Unit) {
        students.forEach { studentModel ->
            val documentPath =
                studentModel.name.toEmpty().replace("\\s".toRegex(), "").toUpperCase(Locale.ROOT)
            // TODO Continue Update
//            db.collection(collectionPath).document(documentPath).set()
        }
    }
}
