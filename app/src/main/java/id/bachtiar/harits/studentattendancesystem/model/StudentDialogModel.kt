package id.bachtiar.harits.studentattendancesystem.model

data class StudentDialog(
    val student: String,
    override var status: Status,
    override var information: String
) : Attendance()