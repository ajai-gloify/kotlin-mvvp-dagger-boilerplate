package com.shekhar.kotlin.dagger.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.di.ActivityContext
import com.shekhar.kotlin.dagger.ui.base.BaseFragment
import com.shekhar.kotlin.dagger.ui.home.HomeViewModel
import com.shekhar.kotlin.dagger.utils.NetworkHelper
import com.shekhar.kotlin.dagger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = fragment.context!!

    @Provides
    fun provideHomeViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ) : HomeViewModel =
            ViewModelProviders.of(fragment,
                    ViewModelProviderFactory(HomeViewModel::class){
                        HomeViewModel(compositeDisposable,networkHelper,databaseService,networkService)

                    }).get(HomeViewModel::class.java)
}
