package com.shekhar.kotlin.dagger.utils

import android.content.Context

import com.shekhar.kotlin.dagger.di.ApplicationContext

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(
        // Should be Application Context
        @ApplicationContext private val context: Context) {

    // will check for network connectivity
    fun isNetworkConnected () = false
}
