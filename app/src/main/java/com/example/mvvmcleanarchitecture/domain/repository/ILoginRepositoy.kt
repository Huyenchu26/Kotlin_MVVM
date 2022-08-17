package com.example.mvvmcleanarchitecture.domain.repository

import com.example.mvvmcleanarchitecture.domain.model.BaseResponse
import com.example.mvvmcleanarchitecture.domain.model.ParamLogin
import com.example.mvvmcleanarchitecture.domain.model.UserModel
import io.reactivex.Single

interface ILoginRepository {

    fun login(paramLogin: ParamLogin?): Single<BaseResponse<UserModel>>

    fun saveToLocal(userModel: UserModel)
}