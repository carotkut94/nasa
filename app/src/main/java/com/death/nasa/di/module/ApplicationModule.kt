package com.death.nasa.di.module

import android.app.Application
import android.content.Context
import com.death.nasa.BuildConfig
import com.death.nasa.NasaApplication
import com.death.nasa.data.remote.di.BaseUrl
import com.death.nasa.di.ApplicationContext
import com.death.nasa.utils.rx.RxSchedulerProviderImpl
import com.death.nasa.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: NasaApplication){

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Singleton
    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @BaseUrl
    fun provideBaseUrl(): String = BuildConfig.BASE_URL


    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProviderImpl()

}