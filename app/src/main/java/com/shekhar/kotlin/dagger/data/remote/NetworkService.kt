package com.shekhar.kotlin.dagger.data.remote

import com.shekhar.kotlin.dagger.data.remote.request.LoginRequest
import com.shekhar.kotlin.dagger.data.remote.response.LoginResponse

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

import javax.inject.Singleton


@Singleton
interface NetworkService {


    @POST(Endpoints.LOGIN)
    fun doLoginCall(
            @Body request: LoginRequest
    ): Single<LoginResponse>
}
