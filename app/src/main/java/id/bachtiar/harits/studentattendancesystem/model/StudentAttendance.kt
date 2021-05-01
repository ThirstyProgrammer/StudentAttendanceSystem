package id.bachtiar.harits.studentattendancesystem.model

import android.os.Parcelable
import id.bachtiar.harits.studentattendancesystem.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudentAttendance(
    val schedule: Schedule,
    val date: String,
    override var status: Status,
    override var information: String,
) : Parcelable, Attendance() {

    fun getContainerColor(): Int {
        return when (status) {
            Status.PRESENT -> R.color.green_500
            Status.SICK -> R.color.blue_500
            Status.PERMIT -> R.color.yellow_500
            Status.NEGLECT -> R.color.red_500
        }
    }
}
