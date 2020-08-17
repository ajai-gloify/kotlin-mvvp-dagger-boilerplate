package com.shekhar.kotlin.dagger.ui.home

import androidx.lifecycle.MutableLiveData
import com.shekhar.kotlin.dagger.data.local.db.DatabaseService
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.di.FragmentScope
import com.shekhar.kotlin.dagger.ui.base.BaseViewModel
import com.shekhar.kotlin.dagger.ui.home.post.Post
import com.shekhar.kotlin.dagger.utils.network.NetworkHelper
import com.shekhar.kotlin.dagger.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

@FragmentScope
class HomeViewModel  (
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) : BaseViewModel(schedulerProvider,compositeDisposable,networkHelper){



    val testData = MutableLiveData<List<Post>>()


    override fun onCreate() {
//        testData.postValue(listOf(
//                Post("Test 1"),
//                Post("Test 2"),
//                Post("Test 3"),
//                Post("Test 4"),
//                Post("Test 5"),
//                Post("Test 6"),
//                Post("Test 7")
//        ))
    }

//    val someData: String
//        get() = (databaseService.dummyData
//                + " : " + networkService.dummyData
//                + " : " + networkHelper.isNetworkConnected)
}
