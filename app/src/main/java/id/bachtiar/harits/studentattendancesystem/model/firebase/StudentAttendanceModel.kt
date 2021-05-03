package id.bachtiar.harits.studentattendancesystem.model.firebase

import id.bachtiar.harits.studentattendancesystem.R
import id.bachtiar.harits.studentattendancesystem.util.toEmpty

data class StudentAttendanceModel(
    val subject: String? = null,
    val status: String? = null,
    val startTime: String? = null,
    val endTime: String? = null,
    val date: String? = null,
    val information: String? = null
) {

    fun getContainerColor(): Int {
        return when (Status.getEnum(status.toEmpty())) {
            Status.PRESENT -> R.color.green_500
            Status.SICK -> R.color.blue_500
            Status.PERMIT -> R.color.yellow_500
            Status.NEGLECT -> R.color.red_500
        }
    }

    enum class Status(val value: String) {
        PRESENT("Hadir"),
        SICK("Sakit"),
        PERMIT("Izin"),
        NEGLECT("Alpa");

        companion object {

            fun getEnum(name: String): Status {
                for (enum in values()) {
                    if (enum.value == name) {
                        return enum
                    }
                }
                return PRESENT
            }
        }
    }
}
