package com.example.mvvmcleanarchitecture.domain.usecase

import android.util.Log
import com.example.mvvmcleanarchitecture.domain.model.BaseResponse
import com.example.mvvmcleanarchitecture.domain.model.ParamLogin
import com.example.mvvmcleanarchitecture.domain.model.UserModel
import com.example.mvvmcleanarchitecture.domain.repository.ILoginRepository
import com.example.mvvmcleanarchitecture.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: ILoginRepository) :
    SingleUseCase<BaseResponse<UserModel>>() {
    private var paramLogin: ParamLogin? = null


    fun saveParamLogin(pr: ParamLogin?) {
        paramLogin = pr
    }


    override fun buildUseCaseSingle(): Single<BaseResponse<UserModel>> {

        return repository.login(paramLogin)
    }

}