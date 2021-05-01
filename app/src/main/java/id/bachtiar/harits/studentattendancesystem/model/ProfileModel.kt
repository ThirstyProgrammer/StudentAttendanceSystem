package id.bachtiar.harits.studentattendancesystem.model

import android.os.Parcelable
import id.bachtiar.harits.studentattendancesystem.util.Constant
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileModel(
    var email: String = Constant.EMPTY_STRING,
    var username: String = Constant.EMPTY_STRING,
    var avatar: String = Constant.EMPTY_STRING,
    var isEmailVerified: Boolean = false
) : ProfilePresenter, Parcelable {

    override fun getIsEmailVerified(): Boolean = isEmailVerified
}