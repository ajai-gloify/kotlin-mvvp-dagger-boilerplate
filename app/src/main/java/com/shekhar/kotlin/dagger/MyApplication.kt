package com.shekhar.kotlin.dagger

import android.app.Application

import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.di.component.ApplicationComponent
import com.shekhar.kotlin.dagger.di.component.DaggerApplicationComponent
import com.shekhar.kotlin.dagger.di.module.ApplicationModule

import javax.inject.Inject

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var databaseService: DatabaseService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }
}