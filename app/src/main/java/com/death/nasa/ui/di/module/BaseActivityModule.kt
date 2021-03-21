package com.death.nasa.ui.di.module

import android.content.Context
import com.death.trendinghub.ui.di.ActivityContext
import com.death.nasa.ui.base.BaseActivity
import com.death.nasa.utils.rx.RxSchedulerProviderImpl
import com.death.nasa.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
abstract class BaseActivityModule(private val activity: BaseActivity<*, *, *>){

    @Provides
    @ActivityContext
    fun provideContext():Context =  activity

    @Provides
    fun provideActivity(): BaseActivity<*,*,*> = activity

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProviderImpl()

}