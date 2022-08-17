package com.example.mvvm.data.source.remote

import com.example.mvvm.domain.model.BaseResponse
import com.example.mvvm.domain.model.ParamLogin
import com.example.mvvm.domain.model.UserModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginApi {

    @POST("auth/login")
    fun login(@Body paramLogin: ParamLogin?): Single<BaseResponse<UserModel>>

}