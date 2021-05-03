package id.bachtiar.harits.studentattendancesystem.util

import java.util.*

fun String?.toEmpty(): String = if (this.isNullOrEmpty()) "" else this
fun String?.toDash(): String = if (this.isNullOrEmpty()) "-" else this
fun String.toCollectionOrDocumentPath(): String = this.replace("\\s".toRegex(), "").toUpperCase(
    Locale.ROOT
)