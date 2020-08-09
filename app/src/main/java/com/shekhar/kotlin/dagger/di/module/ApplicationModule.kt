package com.shekhar.kotlin.dagger.di.module

import android.content.Context
import androidx.room.Room
import com.shekhar.kotlin.dagger.BuildConfig

import com.shekhar.kotlin.dagger.MyApplication
import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.data.remote.Networking
import com.shekhar.kotlin.dagger.di.ApplicationContext
import com.shekhar.kotlin.dagger.di.DatabaseInfo
import com.shekhar.kotlin.dagger.di.NetworkInfo
import com.shekhar.kotlin.dagger.utils.NetworkHelper

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = "dummy_db"

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int = 1

    @Provides
    @NetworkInfo
    fun provideApiKey(): String = "SOME_API_KEY"

    @Singleton
    @Provides
    fun provideDatabaseService():DatabaseService = Room.databaseBuilder(
            application,
            DatabaseService::class.java,
    "database-project-db"
            ).build()


    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @Provides
    fun provideNetworkService(): NetworkService =
            Networking.create(
                    BuildConfig.BASE_URL,
                    application.cacheDir,
                    10 * 1024 * 1024 // 10MB
            )
}
