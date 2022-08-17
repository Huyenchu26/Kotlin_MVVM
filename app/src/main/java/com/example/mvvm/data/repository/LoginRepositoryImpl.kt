package com.example.mvvm.data.repository


import com.example.mvvm.data.source.local.AppDatabase
import com.example.mvvm.data.source.remote.ILoginApi
import com.example.mvvm.domain.model.BaseResponse
import com.example.mvvm.domain.model.ParamLogin
import com.example.mvvm.domain.model.UserModel
import com.example.mvvm.domain.repository.ILoginRepository
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

