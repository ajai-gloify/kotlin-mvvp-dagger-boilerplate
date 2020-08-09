package com.shekhar.kotlin.dagger.di.component

import com.shekhar.kotlin.dagger.di.FragmentScope
import com.shekhar.kotlin.dagger.di.ViewHolderScope
import com.shekhar.kotlin.dagger.di.module.ViewHolderModule
import com.shekhar.kotlin.dagger.ui.home.post.Post
import com.shekhar.kotlin.dagger.ui.home.post.PostViewHolder
import dagger.Component


@ViewHolderScope
@Component(dependencies = [ApplicationComponent::class], modules = [ViewHolderModule::class])
interface ViewHolderComponent {

    fun inject(viewHolder: PostViewHolder)
}