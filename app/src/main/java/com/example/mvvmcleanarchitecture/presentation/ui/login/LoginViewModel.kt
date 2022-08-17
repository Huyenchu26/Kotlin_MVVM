package com.example.mvvmcleanarchitecture.presentation.ui.login

import android.util.Patterns
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanarchitecture.core.Errors
import com.example.mvvmcleanarchitecture.domain.model.BaseResponse
import com.example.mvvmcleanarchitecture.domain.model.ParamLogin
import com.example.mvvmcleanarchitecture.domain.model.UserModel
import com.example.mvvmcleanarchitecture.domain.usecase.LoginUseCase
import com.example.mvvmcleanarchitecture.presentation.base.ext.postNext
import com.example.mvvmcleanarchitecture.presentation.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch


class LoginViewModel @ViewModelInject constructor(private val loginUseCase: LoginUseCase) :
    BaseViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName


    fun onTextChange(email: String) {
        if (isValidEmail(email)) {
            _stateLiveData.postNext { state ->
                state.copy(
                    isShowLoading = false,
                    isError = null,
                    isSuccess = null,
                    showErrorValidEmail = false
                )
            }
        } else {
            _stateLiveData.postNext { state ->
                state.copy(
                    isShowLoading = false,
                    isError = null,
                    isSuccess = null,
                    showErrorValidEmail = true
                )
            }
        }
    }

    private val _stateLiveData: MutableLiveData<LoginViewState<BaseResponse<UserModel>>> =
        MutableLiveData(
            LoginViewState<BaseResponse<UserModel>>(
                isShowLoading = false,
                isError = null,
                isSuccess = null,
                showErrorValidEmail = false
            )
        )

    val stateLiveData: LiveData<LoginViewState<BaseResponse<UserModel>>> = _stateLiveData

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()


    fun login(userName: String?, password: String?) {


        when (userName.isNullOrEmpty() || password.isNullOrEmpty()) {
            true -> _stateLiveData.postNext { state ->
                state.copy(
                    isShowLoading = false,
                    isError = Errors.EmptyInputError,
                    isSuccess = null,
                    showErrorValidEmail = true
                )
            }

            false -> viewModelScope.launch {
                loginUseCase.saveParamLogin(ParamLogin(userName, password))

                _stateLiveData.postNext { state ->
                    state.copy(
                        isShowLoading = true,
                        isError = null,
                        isSuccess = null,
                        showErrorValidEmail = false
                    )
                }

                loginUseCase.execute(onSuccess = {
                    _stateLiveData.postNext { state ->
                        state.copy(
                            isShowLoading = false,
                            isError = null,
                            isSuccess = it, showErrorValidEmail = false

                        )
                    }
                }, onError = {


                    _stateLiveData.postNext { state ->
                        state.copy(
                            isShowLoading = false,
                            isError = it,
                            isSuccess = null, showErrorValidEmail = false

                        )
                    }

                })


            }
        }
    }


}