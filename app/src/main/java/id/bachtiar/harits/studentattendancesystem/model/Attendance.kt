package id.bachtiar.harits.studentattendancesystem.model

abstract class Attendance {
    abstract var status: Status
    abstract val information: String

    enum class Status(value: String) {
        PRESENT("Hadir"),
        SICK("Sakit"),
        PERMIT("Izin"),
        NEGLECT("Alpa");

        companion object {
            fun getValue(status: Status): String {
                return when (status) {
                    PRESENT -> "Hadir"
                    SICK -> "Sakit"
                    PERMIT -> "Izin"
                    NEGLECT -> "Alpa"
                }
            }
        }
    }
}

