package id.bachtiar.harits.studentattendancesystem.util

import android.view.View

fun View.setViewVisibility(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}