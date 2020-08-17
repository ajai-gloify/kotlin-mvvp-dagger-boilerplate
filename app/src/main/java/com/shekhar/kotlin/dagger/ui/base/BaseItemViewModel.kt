package com.shekhar.kotlin.dagger.ui.base

import androidx.lifecycle.MutableLiveData
import com.shekhar.kotlin.dagger.utils.network.NetworkHelper
import com.shekhar.kotlin.dagger.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseItemViewModel<T: Any>(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
) :BaseViewModel(schedulerProvider,compositeDisposable, networkHelper){

    val data = MutableLiveData<T> ()


    fun onManualCleared() = onCleared()

    fun updateData(data : T)
    {
        this.data.postValue(data)
    }
}