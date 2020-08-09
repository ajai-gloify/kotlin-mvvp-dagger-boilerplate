package com.shekhar.kotlin.dagger.di.component

import com.shekhar.kotlin.dagger.di.module.ActivityModule
import com.shekhar.kotlin.dagger.di.ActivityScope
import com.shekhar.kotlin.dagger.ui.main.MainActivity

import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}
