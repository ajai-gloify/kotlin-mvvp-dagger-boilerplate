package com.shekhar.kotlin.dagger.di.component

import com.shekhar.kotlin.dagger.di.module.FragmentModule
import com.shekhar.kotlin.dagger.di.FragmentScope
import com.shekhar.kotlin.dagger.ui.home.HomeFragment

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class],
        modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}
