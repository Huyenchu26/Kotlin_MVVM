package com.example.mvvm.presentation.ui.login

import com.example.mvvm.presentation.base.viewstate.BaseViewState

data class LoginViewState<T>(
    val isShowLoading: Boolean,
    val isError: Throwable?,
    val isSuccess: T?,
    val showErrorValidEmail: Boolean = false
) : BaseViewState<T>(isShowLoading, isError, isSuccess)