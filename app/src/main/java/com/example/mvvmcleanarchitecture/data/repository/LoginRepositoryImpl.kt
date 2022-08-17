package com.example.mvvmcleanarchitecture.data.repository


import com.example.mvvmcleanarchitecture.data.source.local.AppDatabase
import com.example.mvvmcleanarchitecture.data.source.remote.ILoginApi
import com.example.mvvmcleanarchitecture.domain.model.BaseResponse
import com.example.mvvmcleanarchitecture.domain.model.ParamLogin
import com.example.mvvmcleanarchitecture.domain.model.UserModel
import com.example.mvvmcleanarchitecture.domain.repository.ILoginRepository
import io.reactivex.Single
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val iLoginApi: ILoginApi,
    private val hasNetwork: Boolean
) :
    ILoginRepository {
    override fun login(paramLogin: ParamLogin?): Single<BaseResponse<UserModel>> {

        return iLoginApi.login(paramLogin)
    }

    override fun saveToLocal(userModel: UserModel) {
        database.userDao().insert(userModel)
    }

}

