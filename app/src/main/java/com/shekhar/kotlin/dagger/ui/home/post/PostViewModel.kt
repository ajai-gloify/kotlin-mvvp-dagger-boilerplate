package com.shekhar.kotlin.dagger.ui.home.post

import com.shekhar.kotlin.dagger.data.local.db.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.ui.base.BaseItemViewModel
import com.shekhar.kotlin.dagger.utils.network.NetworkHelper
import com.shekhar.kotlin.dagger.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostViewModel @Inject constructor(
        schedulerProvider:SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService
) :BaseItemViewModel<Post>(schedulerProvider,compositeDisposable,networkHelper)
{

    override fun onCreate() {}
}