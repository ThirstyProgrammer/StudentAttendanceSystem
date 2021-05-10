package id.bachtiar.harits.studentattendancesystem.feature.form

import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.bachtiar.harits.studentattendancesystem.base.BaseViewModel
import id.bachtiar.harits.studentattendancesystem.model.AttendanceForm
import id.bachtiar.harits.studentattendancesystem.model.StudentDialog
import id.bachtiar.harits.studentattendancesystem.model.firebase.ScheduleModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel
import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentModel
import id.bachtiar.harits.studentattendancesystem.util.toCollectionOrDocumentPath
import id.bachtiar.harits.studentattendancesystem.util.toEmpty
import id.bachtiar.harits.studentattendancesystem.util.toZero

class FormViewModel : BaseViewModel() {

    lateinit var sharedPreferences: SharedPreferences

    val TAG = "FORM_VIEW_MODEL"
    var students: List<StudentModel> = arrayListOf()
    var updatedStudents: ArrayList<StudentModel> = arrayListOf()
    var notPresentStudent: ArrayList<StudentDialog> = arrayListOf()
    var formDocumentPath: String = ""
    var completedStudentUpdate: Int = 0
    private var db = Firebase.firestore
    private var formCollection = db.collection("FORM")

    fun getStudentByClass(collectionPath: String, onSuccess: (data: List<StudentModel>) -> Unit) {
        handleFirebaseLoading()
        db.collection(collectionPath).get()
            .addOnSuccessListener { result ->
                val data: ArrayList<StudentModel> = arrayListOf()
                result.forEach { document ->
                    val student = document.toObject<StudentModel>()
                    data.add(student)
                }
                students = data
                onSuccess(data)
                handleFirebaseComplete()
            }
            .addOnFailureListener { exception ->
                handleFirebaseComplete()
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    fun createFormDocument(
        formData: AttendanceForm,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ) {
        handleFirebaseLoading()
        formCollection.document(formDocumentPath).set(formData)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onFailed()
                Log.d(TAG, "Error getting documents: ", exception)
                handleFirebaseComplete()
            }
    }

    fun deleteFormDocument() {
        formCollection.document(formDocumentPath).delete()
    }

    fun updateClass(collectionPath: String, onSuccess: () -> Unit, onFailed: () -> Unit) {
        generateStudentData()
        updatedStudents.forEach { studentModel ->
            val documentPath =
                studentModel.name.toEmpty().toCollectionOrDocumentPath()
            db.collection(collectionPath).document(documentPath).set(studentModel)
                .addOnSuccessListener {
                    onSuccess()
                }
                .addOnFailureListener { exception ->
                    onFailed()
                    Log.d(TAG, "Error getting documents: ", exception)
                    handleFirebaseComplete()
                }
        }
    }

    fun updateScheduleLastUpdated(
        collectionPath: String,
        documentPath: String,
        scheduleModel: ScheduleModel,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ) {
        db.collection(collectionPath).document(documentPath).set(scheduleModel)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { exception ->
                onFailed()
                Log.d(TAG, "Error Update Schedule: ", exception)
                handleFirebaseComplete()
            }
    }

    fun addStudentAttendance(
        collectionPath: String,
        documentPath: String,
        attendanceModel: StudentAttendanceModel,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ) {
        db.collection(collectionPath).document(documentPath).set(attendanceModel)
            .addOnSuccessListener {
                completedStudentUpdate += 1
                if (completedStudentUpdate == students.size) {
                    handleFirebaseComplete()
                    onSuccess()
                }
            }
            .addOnFailureListener { exception ->
                onFailed()
                Log.d(TAG, "Error Add Student Attendance: ", exception)
                handleFirebaseComplete()
            }
    }

    private fun generateStudentData() {
        updatedStudents.clear()
        students.forEach { studentModel ->
            val (newStudentModel, isUpdated) = generateNewestStudentData(studentModel)
            if (!isUpdated) newStudentModel.present = newStudentModel.present.toZero() + 1
            updatedStudents.add(newStudentModel)
        }
    }

    private fun generateNewestStudentData(studentModel: StudentModel): Pair<StudentModel, Boolean> {
        notPresentStudent.forEach {
            if (it.student == studentModel.name) {
                when (it.status) {
                    StudentAttendanceModel.Status.SICK -> {
                        studentModel.sick = studentModel.sick.toZero() + 1
                    }
                    StudentAttendanceModel.Status.PERMIT -> {
                        studentModel.permit = studentModel.permit.toZero() + 1
                    }
                    StudentAttendanceModel.Status.NEGLECT -> {
                        studentModel.neglect = studentModel.neglect.toZero() + 1
                    }
                    else -> {
                    }
                }
                notPresentStudent.remove(it)
                return Pair(studentModel, true)
            }
        }
        return Pair(studentModel, false)
    }
}
