package id.bachtiar.harits.studentattendancesystem.model.firebase

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GradeModel(
    var name: String? = null,
    var homeroomTeacher: String? = null,
    var students: Int? = null
) : Parcelable
