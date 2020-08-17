package com.shekhar.kotlin.dagger.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.shekhar.kotlin.dagger.MyApplication
import com.shekhar.kotlin.dagger.di.component.ActivityComponent
import com.shekhar.kotlin.dagger.di.component.DaggerActivityComponent
import com.shekhar.kotlin.dagger.di.module.ActivityModule
import com.shekhar.kotlin.dagger.utils.display.Toaster
import javax.inject.Inject

abstract class BaseActivity<VM :BaseViewModel> :AppCompatActivity(){

    @Inject
    lateinit var viewModel:VM


    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObserver()
        setupView(savedInstanceState)
        viewModel.onCreate()

    }

    protected open fun setupObserver()
    {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }


    private fun buildActivityComponent() =
            DaggerActivityComponent
                    .builder().applicationComponent((application as MyApplication).applicationComponent)
                    .activityModule(ActivityModule(this))
                    .build()


    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))


    @LayoutRes
    protected abstract fun provideLayoutId():Int

    protected abstract fun setupView(saveInstanceId:Bundle?)

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)


}