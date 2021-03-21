package com.death.nasa.ui.di.component

import com.death.nasa.ui.di.ActivityScope
import com.death.nasa.data.repository.di.RepositoryModule
import com.death.nasa.di.component.ApplicationComponent
import com.death.nasa.ui.base.BaseActivity
import com.death.nasa.ui.base.BaseFragment
import com.death.nasa.ui.di.module.MainModule
import com.death.nasa.ui.base.MainActivity
import com.death.nasa.ui.di.FragmentScope
import com.death.nasa.ui.di.module.FragmentModule
import com.death.nasa.ui.home.list.NasaListFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        RepositoryModule::class,
        MainModule::class
    ]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        RepositoryModule::class,
        FragmentModule::class
    ]
)
interface FragmentComponent {
    fun inject(fragment: NasaListFragment)
}

