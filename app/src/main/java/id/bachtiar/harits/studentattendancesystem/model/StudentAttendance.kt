package id.bachtiar.harits.studentattendancesystem.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudentAttendance(
    val schedule: Schedule,
    override var status: Status,
    override val information: String,
) : Parcelable, Attendance()
