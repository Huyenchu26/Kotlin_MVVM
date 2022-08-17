package com.example.mvvmcleanarchitecture.presentation.ui.login

import com.example.mvvmcleanarchitecture.presentation.base.viewstate.BaseViewState

data class LoginViewState<T>(
    val isShowLoading: Boolean,
    val isError: Throwable?,
    val isSuccess: T?,
    val showErrorValidEmail: Boolean = false
) : BaseViewState<T>(isShowLoading, isError, isSuccess)