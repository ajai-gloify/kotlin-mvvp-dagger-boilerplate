package com.shekhar.kotlin.dagger.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shekhar.kotlin.dagger.data.local.DatabaseService
import com.shekhar.kotlin.dagger.data.local.entity.Address
import com.shekhar.kotlin.dagger.data.local.entity.User
import com.shekhar.kotlin.dagger.data.remote.NetworkService
import com.shekhar.kotlin.dagger.di.ActivityScope
import com.shekhar.kotlin.dagger.ui.base.BaseViewModel
import com.shekhar.kotlin.dagger.utils.NetworkHelper
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

@ActivityScope
class MainViewModel (
       compositeDisposable: CompositeDisposable,
       networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) :BaseViewModel(compositeDisposable,networkHelper){


    override fun onCreate() {
    }


    val user = MutableLiveData<User>()
    val users = MutableLiveData<List<User>>()
    var allUser : List<User> = emptyList()
    var allAddress : List<Long> = emptyList()

    companion object{
        const val TAG = "MainViewModel"
    }

    init {

        compositeDisposable.add(

                databaseService.userDao().count().flatMap {
                    if (it == 0)

                                databaseService.addressDao()
                                        .insertMany(
                                        Address(city = "Delhi",country = "India"),
                                        Address(city = "New York",country = "US"),
                                        Address(city = "Berlin",country = "Germany"),
                                        Address(city = "London",country = "UK"),
                                        Address(city = "Bangalore",country = "India"),
                                        Address(city = "Barcelona",country = "Spain")
                                )
                                        .flatMap {addressId->
                                            databaseService.userDao()
                                                    .insertMany(
                                                            User(name = "User 1", addressId = addressId[0],date_of_birth = Date(9596845779)),
                                                            User(name = "User 2", addressId = addressId[1],date_of_birth = Date(9596845779)),
                                                            User(name = "User 3", addressId = addressId[2],date_of_birth = Date(9596845779)),
                                                            User(name = "User 4", addressId = addressId[3],date_of_birth = Date(9596845779)),
                                                            User(name = "User 5", addressId = addressId[4],date_of_birth = Date(9596845779)),
                                                            User(name = "User 6", addressId = addressId[5],date_of_birth = Date(9596845779))
                                                    )
                                        }


                    else Single.just(0)
                }.subscribeOn(Schedulers.io())
                .subscribe(
                {
                    Log.e(TAG,"user exist in table $it")
                },
                {
                    Log.e(TAG,it.toString())
                })
        )

    }


    fun getAllUsers()
    {
        compositeDisposable.add(
                databaseService.userDao()
                        .getAllUsers()
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    allUser = it
                                    users.postValue(it)
                                },
                                {
                                    Log.e(TAG,it.toString())
                                }
                        )
        )
    }

    fun deleteUser()
    {
        if (allUser.isNotEmpty())
        compositeDisposable.add(
                databaseService.userDao()
                        .delete(allUser[0])
                        .subscribeOn(Schedulers.io())
                        .flatMap {
                            databaseService.userDao().getAllUsers()
                        }
                        .subscribe(
                                {
                                    allUser = it
                                    users.postValue(it)
                                },
                                {
                                    Log.e(TAG,it.toString())
                                }
                        )
        )
    }

    fun onDestroy()
    {
        compositeDisposable.dispose()
    }



}
