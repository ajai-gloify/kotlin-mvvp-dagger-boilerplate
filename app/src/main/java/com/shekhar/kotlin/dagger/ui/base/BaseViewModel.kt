package com.shekhar.kotlin.dagger.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shekhar.kotlin.dagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
        protected var compositeDisposable: CompositeDisposable,
        protected var networkHelper: NetworkHelper
) :ViewModel(){

    protected fun checkInternet() :Boolean = networkHelper.isNetworkConnected()

    val messageStringId = MutableLiveData<Int>()
    val messageString = MutableLiveData<String>()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    abstract fun onCreate()


}