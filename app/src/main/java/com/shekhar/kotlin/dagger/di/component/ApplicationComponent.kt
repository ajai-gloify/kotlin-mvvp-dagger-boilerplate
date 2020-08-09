package com.shekhar.kotlin.dagger.di.component

import android.content.Context
import com.shekhar.kotlin.dagger.MyApplication
import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.di.ApplicationContext
import com.shekhar.kotlin.dagger.di.module.ApplicationModule
import com.shekhar.kotlin.dagger.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable


}
