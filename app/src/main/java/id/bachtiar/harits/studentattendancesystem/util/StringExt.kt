package id.bachtiar.harits.studentattendancesystem.util

fun String?.toEmpty(): String = if (this.isNullOrEmpty()) "" else this
fun String?.toDash(): String = if (this.isNullOrEmpty()) "-" else this