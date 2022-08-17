package com.example.mvvmcleanarchitecture.presentation.ui.login

import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.Errors
import com.example.mvvmcleanarchitecture.domain.model.BaseResponse
import com.example.mvvmcleanarchitecture.domain.model.UserModel
import com.example.mvvmcleanarchitecture.presentation.base.ext.observe
import com.example.mvvmcleanarchitecture.presentation.base.ui.BaseFragment
import com.example.mvvmcleanarchitecture.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.HttpException

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_login
    override fun initView() {
    }

    override fun initData() {
        binds()
    }

    private val loginViewModel: LoginViewModel by viewModels()


    private fun binds() {

        mBtnSignIn.setSafeOnClickListener {
            loginViewModel.login(tvUsername.text.toString(), tvPassword.text.toString())
        }

        tvUsername.doOnTextChanged { text, _, _, _ ->
            run {

                loginViewModel.onTextChange(text.toString())
            }
        }

        observe(loginViewModel.stateLiveData, this::onNewState)
    }


    private fun onNewState(state: LoginViewState<BaseResponse<UserModel>>) {
        if (state.throwable != null) {
            when (state.throwable) {
                is Errors.EmptyInputError -> "username or password can't be null."
                is HttpException ->
                    when (state.throwable.code()) {
                        401 -> "username or password failure."
                        else -> "network failure"
                    }
                is Errors.NoInternetError -> "No Internet"
                else -> "network failure"
            }.also { str ->
                toast { str }
            }
        }


        mProgressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
        txtErrorEmail.visibility = if (state.showErrorValidEmail) View.VISIBLE else View.GONE

        if (state.result != null) {

            if (state.result.code != 1) {
                toast { state.result.message }
            } else {
                toast { state.result.data?.userName.toString() }

            }

        }

    }

}