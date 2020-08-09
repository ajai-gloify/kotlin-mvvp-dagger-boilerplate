package com.shekhar.kotlin.dagger.di.component

import com.shekhar.kotlin.dagger.di.FragmentScope
import com.shekhar.kotlin.dagger.di.module.ViewHolderModule
import dagger.Component


@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [ViewHolderModule::class])
interface ViewHolderComponent {
}