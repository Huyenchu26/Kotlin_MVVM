package com.example.mvvm.domain.repository

import com.example.mvvm.domain.model.BaseResponse
import com.example.mvvm.domain.model.ParamLogin
import com.example.mvvm.domain.model.UserModel
import io.reactivex.Single

interface ILoginRepository {

    fun login(paramLogin: ParamLogin?): Single<BaseResponse<UserModel>>

    fun saveToLocal(userModel: UserModel)
}