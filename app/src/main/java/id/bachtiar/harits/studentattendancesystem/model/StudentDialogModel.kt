package id.bachtiar.harits.studentattendancesystem.model

import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel

data class StudentDialog(
    val student: String,
    override var status: StudentAttendanceModel.Status,
    override var information: String
) : Attendance()