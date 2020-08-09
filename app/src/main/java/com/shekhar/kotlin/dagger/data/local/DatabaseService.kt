package com.shekhar.kotlin.dagger.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shekhar.kotlin.dagger.data.local.dao.AddressDao
import com.shekhar.kotlin.dagger.data.local.dao.UserDao
import com.shekhar.kotlin.dagger.data.local.entity.Address
import com.shekhar.kotlin.dagger.data.local.entity.User


@Database(entities = [
    User::class,
    Address::class],
    version = 1,
    exportSchema = false)

@TypeConverters(Converter::class)
abstract class DatabaseService : RoomDatabase(){

    abstract fun userDao():UserDao

    abstract fun addressDao():AddressDao

}

