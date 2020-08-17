package com.shekhar.kotlin.dagger.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.shekhar.kotlin.dagger.data.local.db.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.di.ActivityContext
import com.shekhar.kotlin.dagger.ui.base.BaseFragment
import com.shekhar.kotlin.dagger.ui.home.HomeViewModel
import com.shekhar.kotlin.dagger.ui.home.post.PostAdapter
import com.shekhar.kotlin.dagger.utils.ViewModelProviderFactory
import com.shekhar.kotlin.dagger.utils.network.NetworkHelper
import com.shekhar.kotlin.dagger.utils.rx.SchedulerProvider
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
            schedulerProvider: SchedulerProvider,
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ) : HomeViewModel =
            ViewModelProviders.of(fragment,
                    ViewModelProviderFactory(HomeViewModel::class){
                        HomeViewModel(schedulerProvider,compositeDisposable,networkHelper,databaseService,networkService)

                    }).get(HomeViewModel::class.java)


    @Provides
    fun provideLinearLayoutManager() = LinearLayoutManager(fragment.context)


    @Provides
    fun providePostAdapter() = PostAdapter(fragment.lifecycle,ArrayList())


}
