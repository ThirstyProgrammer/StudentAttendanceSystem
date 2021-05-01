package id.bachtiar.harits.studentattendancesystem.util

import androidx.annotation.Keep

@Keep
class Constant private constructor() {

    companion object {
        const val EMPTY_STRING = ""
        const val ZERO_VALUE = 0

        const val SIGN_IN_REQUEST_CODE = 102
    }

    object Config {
        const val APP_PREFERENCE = "sas_preference"
    }

    object Preference {
        const val IS_USER_LOGIN = "is_user_login"
        const val IS_ONBOARDING_LAUNCH = "is_onboarding_launch"
        const val USER_PROFILE_RESULT = "userProfileResult"
        const val USER_TOKEN = "userToken"

        const val TIMER_VERIFICATION = "update_verification_email"
    }
}