package com.example.mvvmcleanarchitecture.data.source.remote

import com.example.mvvmcleanarchitecture.domain.model.BaseResponse
import com.example.mvvmcleanarchitecture.domain.model.ParamLogin
import com.example.mvvmcleanarchitecture.domain.model.UserModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginApi {

    @POST("auth/login")
    fun login(@Body paramLogin: ParamLogin?): Single<BaseResponse<UserModel>>

}