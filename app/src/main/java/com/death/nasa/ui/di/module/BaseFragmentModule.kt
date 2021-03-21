package com.death.nasa.ui.di.module

import com.death.nasa.ui.base.BaseFragment
import com.death.nasa.utils.rx.RxSchedulerProviderImpl
import com.death.nasa.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
abstract class BaseFragmentModule(private val fragment: BaseFragment<*, *, *>) {

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProviderImpl()

}