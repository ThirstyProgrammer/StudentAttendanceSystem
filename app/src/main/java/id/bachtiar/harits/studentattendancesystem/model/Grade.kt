package id.bachtiar.harits.studentattendancesystem.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Grade(
    val name: String,
    val homeroomTeacher: String,
    val students: List<Student>
) : Parcelable {

    fun getTotalStudents(): String = students.size.toString()
}
