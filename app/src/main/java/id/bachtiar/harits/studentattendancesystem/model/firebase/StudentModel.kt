package id.bachtiar.harits.studentattendancesystem.model.firebase

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudentModel(
    val name: String? = null,
    val gender: String? = null,
    var present: Int? = 0,
    var sick: Int? = 0,
    var permit: Int? = 0,
    var neglect: Int? = 0
) : Parcelable
