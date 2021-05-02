package id.bachtiar.harits.studentattendancesystem.model.firebase

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StudentModel(
    val name: String? = null,
    val gender: String? = null,
    val present: Int? = 0,
    val sick: Int? = 0,
    val permit: Int? = 0,
    val neglect: Int? = 0
) : Parcelable
