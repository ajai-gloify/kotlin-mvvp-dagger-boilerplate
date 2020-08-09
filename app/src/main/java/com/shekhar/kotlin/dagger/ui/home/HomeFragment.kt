package com.shekhar.kotlin.dagger.ui.home

import android.os.Bundle
import android.view.View
import com.shekhar.kotlin.dagger.R
import com.shekhar.kotlin.dagger.di.component.FragmentComponent
import com.shekhar.kotlin.dagger.ui.base.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }




    override fun provideLayoutId(): Int = R.layout.fragment_home

    override fun setupView(view: View) {
        TODO("Not yet implemented")
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }


    override fun setupObserver() {
        super.setupObserver()

    }


}
