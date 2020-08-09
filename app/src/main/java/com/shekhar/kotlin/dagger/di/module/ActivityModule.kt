package com.shekhar.kotlin.dagger.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService

import com.shekhar.kotlin.dagger.di.ActivityContext
import com.shekhar.kotlin.dagger.ui.base.BaseActivity
import com.shekhar.kotlin.dagger.ui.main.MainViewModel
import com.shekhar.kotlin.dagger.utils.NetworkHelper
import com.shekhar.kotlin.dagger.utils.ViewModelProviderFactory

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity



    @Provides
    fun provideMainViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ) :MainViewModel =
            ViewModelProviders.of(activity,
                    ViewModelProviderFactory(MainViewModel::class){
                        MainViewModel(compositeDisposable,networkHelper,databaseService,networkService)

            }).get(MainViewModel::class.java)
}
