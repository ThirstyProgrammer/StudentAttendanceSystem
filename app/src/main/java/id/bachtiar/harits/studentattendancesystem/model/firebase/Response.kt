package id.bachtiar.harits.studentattendancesystem.model.firebase

data class GradeResponse(
    var grade: List<GradeModel>? = null,
    var exception: Exception? = null
)
