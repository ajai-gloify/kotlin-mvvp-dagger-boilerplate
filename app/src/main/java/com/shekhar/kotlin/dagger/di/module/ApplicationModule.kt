package com.shekhar.kotlin.dagger.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.shekhar.kotlin.dagger.BuildConfig

import com.shekhar.kotlin.dagger.MyApplication
import com.shekhar.kotlin.dagger.data.local.db.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.data.remote.Networking
import com.shekhar.kotlin.dagger.di.ApplicationContext
import com.shekhar.kotlin.dagger.di.DatabaseInfo
import com.shekhar.kotlin.dagger.di.NetworkInfo
import com.shekhar.kotlin.dagger.utils.network.NetworkHelper
import com.shekhar.kotlin.dagger.utils.rx.RxSchedulerProvider
import com.shekhar.kotlin.dagger.utils.rx.SchedulerProvider

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
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()


    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
            application.getSharedPreferences("project-prefs", Context.MODE_PRIVATE)


    @Provides
    @NetworkInfo
    fun provideApiKey(): String = "SOME_API_KEY"

    @Singleton
    @Provides
    fun provideDatabaseService(): DatabaseService = Room.databaseBuilder(
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
