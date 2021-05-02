package id.bachtiar.harits.studentattendancesystem.util

import java.text.SimpleDateFormat
import java.util.*

object StringHelper {
    const val LOCALE_ID = "id"

    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale(LOCALE_ID))
        dateFormat.timeZone = TimeZone.getTimeZone("GMT+7")
        val today = Calendar.getInstance().time
        return dateFormat.format(today)
    }

    fun getCurrentDay(): String {
        val dateFormat = SimpleDateFormat("EEEE", Locale(LOCALE_ID))
        dateFormat.timeZone = TimeZone.getTimeZone("GMT+7")
        val today = Calendar.getInstance().time
        return dateFormat.format(today)
    }
}