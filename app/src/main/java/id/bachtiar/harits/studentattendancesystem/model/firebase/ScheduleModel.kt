package id.bachtiar.harits.studentattendancesystem.model.firebase

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleModel(
    val subject: String? = null,
    val day: String? = null,
    val grade: String? = null,
    val startTime: String? = null,
    val endTime: String? = null
) : Parcelable
