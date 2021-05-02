package id.bachtiar.harits.studentattendancesystem.model

import id.bachtiar.harits.studentattendancesystem.model.firebase.StudentAttendanceModel

abstract class Attendance {
    abstract var status: StudentAttendanceModel.Status
    abstract var information: String
}

