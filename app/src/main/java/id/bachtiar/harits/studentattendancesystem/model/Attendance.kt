package id.bachtiar.harits.studentattendancesystem.model

abstract class Attendance{
    abstract var status: Status
    abstract val information: String

    enum class Status {
        SICK,
        PERMIT,
        NEGLECT
    }
}

