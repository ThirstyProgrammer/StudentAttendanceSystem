package id.bachtiar.harits.studentattendancesystem.model

import com.google.firebase.auth.FirebaseUser
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import id.bachtiar.harits.studentattendancesystem.model.firebase.UserModel
import id.bachtiar.harits.studentattendancesystem.util.Constant
import id.bachtiar.harits.studentattendancesystem.util.toDash
import org.json.JSONObject

class Profile constructor(jsonString: String) : ProfilePresenter {

    var userProfile: ProfileModel = ProfileModel()

    private var moshi: Moshi = Moshi.Builder().build()

    init {
        if (jsonString.isNotEmpty()) {
            val data: JSONObject = JSONObject(jsonString).getJSONObject("data")

            userProfile =
                moshi.adapter(ProfileModel::class.java).fromJson(data.toString()) ?: ProfileModel()
        }
    }

    override fun getIsEmailVerified(): Boolean = userProfile.getIsEmailVerified()

    fun convertToStringJson(firebaseUser: FirebaseUser, userDocument: UserModel): String {
        val jsonProfile: MutableMap<String, Any> = LinkedHashMap()
        val json: MutableMap<String, Any> = LinkedHashMap()
        json["email"] = firebaseUser.email ?: Constant.EMPTY_STRING
        json["username"] = userDocument.name.toDash()
        json["role"] = userDocument.role.toDash()
        json["grades"] = userDocument.grades.toDash()
        json["subjects"] = userDocument.subjects.toDash()
        json["avatar"] = firebaseUser.photoUrl ?: Constant.EMPTY_STRING
        json["isEmailVerified"] = firebaseUser.isEmailVerified
        jsonProfile["data"] = json


        val type = Types.newParameterizedType(
            Map::class.java,
            String::class.java,
            Any::class.java
        )
        return moshi.adapter<Map<String, Any>>(type)
            .toJson(jsonProfile)
    }
}