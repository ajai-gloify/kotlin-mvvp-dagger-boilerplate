package com.shekhar.kotlin.dagger.di.component

import com.shekhar.kotlin.dagger.di.module.ActivityModule
import com.shekhar.kotlin.dagger.di.ActivityScope
import com.shekhar.kotlin.dagger.ui.login.LoginActivity
import com.shekhar.kotlin.dagger.ui.main.MainActivity
import com.shekhar.kotlin.dagger.ui.signup.SignupActivity

import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: LoginActivity)

    fun inject(activity: SignupActivity)
}
