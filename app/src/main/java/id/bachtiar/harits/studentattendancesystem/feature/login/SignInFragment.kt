package id.bachtiar.harits.studentattendancesystem.feature.login

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.bachtiar.harits.studentattendancesystem.databinding.FragmentSigninBinding
import id.bachtiar.harits.studentattendancesystem.databinding.ViewStateBinding
import id.bachtiar.harits.studentattendancesystem.util.Constant
import id.mufid.android.widget.ViewState
import id.mufid.android.widget.setErrorLayoutEnable
import id.mufid.android.widget.setLoadingEnable
import id.mufid.android.widget.setSuccessEnable

class SignInFragment : Fragment(), ViewState.RetryRequest {

    private lateinit var viewBinding: FragmentSigninBinding
    private lateinit var viewModel: SignInViewModel
    var mViewStateType = ViewState.ViewStateType.DEFAULT

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSigninBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(SignInViewModel::class.java)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sharedPreferences = requireActivity().application.getSharedPreferences(
            Constant.Config.APP_PREFERENCE,
            MODE_PRIVATE
        )
        handlingViewState(viewBinding.containerMain, viewBinding.viewState, this)

        viewBinding.btnLogin.setOnClickListener {
            submitLogin()
        }
    }

    override fun retry(response: ViewState.ResponseType) {
        submitLogin()
    }

    override fun handleUnAuthorized() {}
    override fun handleFailedRequest(message: String, respone: ViewState.ResponseType) {}

    private fun submitLogin() {
        val email = viewBinding.email.text.toString()
        val password = viewBinding.password.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()) {
            viewModel.signInWithPassword(email, password, ::onSuccess, ::onFailed)
        } else {
            Toast.makeText(
                requireContext(),
                "Masukkan email dan password anda",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun onSuccess() {
        val directions = SignInFragmentDirections.actionLoginFragmentToMainActivity()
        findNavController().navigate(directions)
    }

    private fun onFailed() {
        Toast.makeText(requireContext(), "Autentikasi Bermasalah", Toast.LENGTH_LONG).show()
    }

    private fun handlingViewState(
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