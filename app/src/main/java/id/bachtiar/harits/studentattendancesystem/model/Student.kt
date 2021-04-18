package id.bachtiar.harits.studentattendancesystem.model

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val name: String,
    val gender: String,
    val religion: String,
    val attendance: List<StudentAttendance>
) : Parcelable {
    @IgnoredOnParcel
    private var totalSick: Int = 0

    @IgnoredOnParcel
    private var totalPermit: Int = 0

    @IgnoredOnParcel
    private var totalNeglect: Int = 0

    init {
        attendance.forEach {
            when (it.status) {
                Attendance.Status.SICK -> totalSick += 1
                Attendance.Status.PERMIT -> totalPermit += 1
                Attendance.Status.NEGLECT -> totalNeglect += 1
            }
        }
    }

    fun getTotalSick(): String = totalSick.toString()
    fun getTotalPermit(): String = totalPermit.toString()
    fun getTotalNeglect(): String = totalNeglect.toString()
}
