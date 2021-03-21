package com.death.nasa.ui.di

import com.death.nasa.di.injector.ApplicationInjector
import com.death.nasa.ui.base.BaseActivity
import com.death.nasa.ui.base.BaseFragment
import com.death.nasa.ui.di.component.DaggerMainActivityComponent
import com.death.nasa.ui.di.module.MainModule
import com.death.nasa.ui.base.MainActivity
import com.death.nasa.ui.di.component.DaggerFragmentComponent
import com.death.nasa.ui.di.module.FragmentModule
import com.death.nasa.ui.home.list.NasaListFragment


object Injector{

    fun<A: BaseActivity<*, *, *>> inject(activity: A){
        when(activity){
            is MainActivity -> DaggerMainActivityComponent.builder().applicationComponent(
                ApplicationInjector.applicationComponent)
                .mainModule(MainModule(activity))
                .build()
                .inject(activity)
        }
    }

}

object FragmentInjector {
    fun <F : BaseFragment<*, *, *>> inject(fragment: F) {
        when(fragment){
            is NasaListFragment -> DaggerFragmentComponent.builder().applicationComponent(
                ApplicationInjector.applicationComponent)
                .fragmentModule(FragmentModule(fragment))
                .build()
                .inject(fragment)
        }
    }
}