package com.shekhar.kotlin.dagger.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse (

    @Expose
    @SerializedName("token")
    val token: String,

        @Expose
    @SerializedName("user")
    val user: String

)