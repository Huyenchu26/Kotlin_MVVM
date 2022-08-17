package com.example.mvvmcleanarchitecture.domain.model

data class BaseResponse<T>(
    var code: Int,
    var message: String,
    var data: T?,
    var redirectUrl: String,
    var Successed: Boolean
)