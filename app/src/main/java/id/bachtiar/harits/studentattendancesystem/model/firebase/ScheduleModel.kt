package id.bachtiar.harits.studentattendancesystem.model.firebase

import android.os.Parcelable
import id.bachtiar.harits.studentattendancesystem.R
import id.bachtiar.harits.studentattendancesystem.util.StringHelper
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleModel(
    val subject: String? = null,
    val day: String? = null,
    val grade: String? = null,
    val startTime: String? = null,
    val endTime: String? = null,
    var updatedAt: String? = null
) : Parcelable {

    fun getContainerColor(): Int {
        return if (updatedAt == StringHelper.getCurrentDate()) R.color.green_500_light else R.color.white
    }

    fun isNotSubmitted(): Boolean = updatedAt != StringHelper.getCurrentDate()
}
