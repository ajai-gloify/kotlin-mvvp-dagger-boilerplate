package com.shekhar.kotlin.dagger.ui.home

import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.di.FragmentScope
import com.shekhar.kotlin.dagger.ui.base.BaseViewModel
import com.shekhar.kotlin.dagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

@FragmentScope
class HomeViewModel  (
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) : BaseViewModel(compositeDisposable,networkHelper){


    override fun onCreate() {
    }

//    val someData: String
//        get() = (databaseService.dummyData
//                + " : " + networkService.dummyData
//                + " : " + networkHelper.isNetworkConnected)
}
