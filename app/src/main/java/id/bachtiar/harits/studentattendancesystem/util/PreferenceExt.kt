package id.bachtiar.harits.studentattendancesystem.util

import android.content.SharedPreferences
import id.bachtiar.harits.studentattendancesystem.model.Profile
import id.bachtiar.harits.studentattendancesystem.model.ProfileModel

fun SharedPreferences.pushInt(key: String, value: Int = Constant.ZERO_VALUE) {
    edit().putInt(key, value).apply()
}

fun SharedPreferences.pushLong(key: String, value: Long = 0L) {
    edit().putLong(key, value).apply()
}

fun SharedPreferences.pushString(key: String, value: String = Constant.EMPTY_STRING) {
    edit().putString(key, value).apply()
}

fun SharedPreferences.pushStringSet(key: String, value: Set<String>) {
    edit().putStringSet(key, value).apply()
}

fun SharedPreferences.pushBoolean(key: String, value: Boolean = false) {
    edit().putBoolean(key, value).apply()
}

fun SharedPreferences.reset() {
    edit().clear().apply()
}

fun SharedPreferences.isUserAvailableToAccess(): Boolean {
    return getBoolean(Constant.Preference.IS_USER_LOGIN, false) && getProfile().getIsEmailVerified()
}

fun SharedPreferences.isUserLogin(): Boolean {
    return getBoolean(Constant.Preference.IS_USER_LOGIN, false)
}

fun SharedPreferences.setupProfileResults(json: String?) {
    pushString(Constant.Preference.USER_PROFILE_RESULT, json.toString())
}

fun SharedPreferences.setToken(token: String) {
    pushString(Constant.Preference.USER_TOKEN, token)
}

fun SharedPreferences.getToken(): String {
    return getString(Constant.Preference.USER_TOKEN, Constant.EMPTY_STRING) ?: Constant.EMPTY_STRING
}

fun SharedPreferences.getUserProfile(): ProfileModel {
    val jsonProfile = getString(Constant.Preference.USER_PROFILE_RESULT, Constant.EMPTY_STRING)
        ?: Constant.EMPTY_STRING
    return Profile(jsonProfile).userProfile
}

fun SharedPreferences.getProfile(): Profile {
    val jsonProfile = getString(Constant.Preference.USER_PROFILE_RESULT, Constant.EMPTY_STRING)
        ?: Constant.EMPTY_STRING
    return Profile(jsonProfile)
}

fun SharedPreferences.setDefaultConfig() {
    pushBoolean(Constant.Preference.IS_USER_LOGIN, false)
    pushBoolean(Constant.Preference.IS_ONBOARDING_LAUNCH, true)
}

fun SharedPreferences.logout() {
    reset()
    setDefaultConfig()
}