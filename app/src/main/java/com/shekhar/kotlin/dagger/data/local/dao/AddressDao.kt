package com.shekhar.kotlin.dagger.data.local.dao

import androidx.room.*
import com.shekhar.kotlin.dagger.data.local.entity.Address
import io.reactivex.Single

@Dao
interface AddressDao     {


    @Delete
    fun delete (address: Address): Single<Int>

    @Insert
    fun insertMany(vararg address: Address): Single<List<Long>>

    @Query("SELECT * FROM address")
    fun getAllAddresses() :Single<List<Address>>


}