package com.death.nasa.di.component

import android.app.Application
import android.content.Context
import com.death.nasa.NasaApplication
import com.death.nasa.data.remote.NetworkService
import com.death.nasa.data.remote.di.NetworkModule
import com.death.nasa.data.repository.di.RepositoryModule
import com.death.nasa.di.ApplicationContext
import com.death.nasa.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    RepositoryModule::class
])
@Singleton
interface ApplicationComponent{
    fun inject(app: NasaApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getApplication(): Application

    fun getNetworkService(): NetworkService
}