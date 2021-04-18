package id.bachtiar.harits.studentattendancesystem.model

data class User(
    val name: String,
    val subjects: List<String>,
    val gradeOwned: Grade
)
