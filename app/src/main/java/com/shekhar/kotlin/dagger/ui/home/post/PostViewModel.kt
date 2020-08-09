package com.shekhar.kotlin.dagger.ui.home.post

import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.ui.base.BaseItemViewModel
import com.shekhar.kotlin.dagger.ui.base.BaseViewModel
import com.shekhar.kotlin.dagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostViewModel @Inject constructor(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService
) :BaseItemViewModel<Post>(compositeDisposable,networkHelper)
{

    override fun onCreate() {
    }
}