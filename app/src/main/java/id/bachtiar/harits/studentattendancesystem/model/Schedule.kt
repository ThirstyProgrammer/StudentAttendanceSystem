package id.bachtiar.harits.studentattendancesystem.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(
    val subjects: String,
    val grade: String,
    val startTime: String,
    val endTime: String,
    val day: String,
) : Parcelable