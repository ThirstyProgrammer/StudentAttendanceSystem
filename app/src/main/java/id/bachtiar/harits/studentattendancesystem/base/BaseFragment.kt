package id.bachtiar.harits.studentattendancesystem.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import id.bachtiar.harits.studentattendancesystem.databinding.ViewStateBinding
import id.bachtiar.harits.studentattendancesystem.widget.ViewState
import id.bachtiar.harits.studentattendancesystem.widget.setErrorLayoutEnable
import id.bachtiar.harits.studentattendancesystem.widget.setLoadingEnable
import id.bachtiar.harits.studentattendancesystem.widget.setSuccessEnable

abstract class BaseFragment<T: BaseViewModel>: Fragment() {

    lateinit var viewModel: T
    var mViewStateType = ViewState.ViewStateType.DEFAULT

    fun handlingViewState(
        mainContainer: View?,
        viewStateBinding: ViewStateBinding?,
        retryRequest: ViewState.RetryRequest?
    ) {
        viewModel.mutableViewState.observe(viewLifecycleOwner, Observer { viewState ->
            when (viewState.stateStatus) {
                ViewState.Status.PROGRESSING -> {
                    viewStateBinding?.setLoadingEnable(mainContainer, mViewStateType)
                }
                ViewState.Status.ERROR -> {
                    viewStateBinding?.setErrorLayoutEnable(
                        mainContainer,
                        viewState.isErrorBlocking,
                        !viewState.isErrorUnknown,
                        if (!viewState.stringMessage.isNullOrEmpty()) viewState.stringMessage else "Sepertinya terjadi kesalahan, silakan coba lagi."
                    )
                    if (viewState.isErrorBlocking) {
                        viewStateBinding?.btnRetry?.setOnClickListener {
                            retryRequest?.retry(viewState.response)
                        }
                    } else {
                        retryRequest?.handleFailedRequest(
                            viewState.stringMessage
                                ?: "Sepertinya terjadi kesalahan, silakan coba lagi.",
                            viewState.response
                        )
                    }
                }
                ViewState.Status.UNKNOWN -> {
                }
                ViewState.Status.UNAUTHORIZED -> {
                }
                ViewState.Status.GONE -> {
                    viewStateBinding?.setSuccessEnable(mainContainer)
                }
            }
        })
    }
}