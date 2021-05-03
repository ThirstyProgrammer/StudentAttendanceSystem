package id.bachtiar.harits.studentattendancesystem.widget

import android.view.View
import id.bachtiar.harits.studentattendancesystem.R
import id.bachtiar.harits.studentattendancesystem.databinding.ViewStateBinding

data class ViewState(
    var stateStatus: Status = Status.GONE,
    var stringMessage: String? = null,
    var isErrorBlocking: Boolean = false,
    var isErrorUnknown: Boolean = false,
    var response: ResponseType = ResponseType.DEFAULT
) {
    enum class Status {
        UNKNOWN,
        PROGRESSING,
        ERROR,
        UNAUTHORIZED,
        GONE
    }

    // Choosing Response Type
    enum class ResponseType {
        DEFAULT, REGISTER
    }

    // Choosing Loading View Type
    enum class ViewStateType {
        DEFAULT
    }

    interface RetryRequest {
        fun retry(response: ResponseType)
        fun handleUnAuthorized()
        fun handleFailedRequest(message: String, respone: ResponseType)
    }
}

fun ViewStateBinding.setLoadingEnable(mainContainer: View?) {
    setLoadingEnable(mainContainer, ViewState.ViewStateType.DEFAULT)
}

fun ViewStateBinding.setLoadingEnable(mainContainer: View?, type: ViewState.ViewStateType) {
    mainContainer?.visibility = View.GONE
    containerLoading.visibility = View.VISIBLE
    layoutLoading.visibility = View.VISIBLE
    layoutError.visibility = View.GONE
}

fun ViewStateBinding.setSuccessEnable(mainContainer: View?) {
    mainContainer?.visibility = View.VISIBLE
    this.containerLoading.visibility = View.GONE
}

fun ViewStateBinding.setErrorLayoutEnable(
    mainContainer: View?,
    isErrorBlocking: Boolean
) {
    setErrorLayoutEnable(
        mainContainer,
        isErrorBlocking,
        false,
        "Sepertinya ada yang bermasalah dengan hidup anda."
    )
}

fun ViewStateBinding.setErrorLayoutEnable(
    mainContainer: View?,
    isErrorBlocking: Boolean,
    isErrorUnknown: Boolean,
    message: String?
) {
    this.containerLoading.visibility = View.VISIBLE
    this.layoutLoading.visibility = View.GONE
    this.tvErrorMessage.text = message

    if (isErrorBlocking) {
        mainContainer?.visibility = View.GONE
        this.layoutError.visibility = View.VISIBLE
        if (isErrorUnknown) {
            this.imgErrorResponse.setImageResource(
                if (!message.isNullOrEmpty() && message.contains("internet", ignoreCase = true)) {
                    this.tvErrorTitle.text = "Koneksi Terputus"
                    R.drawable.bg_error
                } else {
                    R.drawable.bg_error
                }
            )

        }
    } else {
        mainContainer?.visibility = View.VISIBLE
        this.layoutError.visibility = View.GONE
    }
}
