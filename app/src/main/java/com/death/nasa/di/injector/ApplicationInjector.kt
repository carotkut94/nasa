package com.death.nasa.di.injector

import com.death.nasa.NasaApplication
import com.death.nasa.data.remote.di.NetworkModule
import com.death.nasa.di.component.ApplicationComponent
import com.death.nasa.di.component.DaggerApplicationComponent
import com.death.nasa.di.module.ApplicationModule

object ApplicationInjector{

    lateinit var applicationComponent: ApplicationComponent

    fun inject(application: NasaApplication){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(application))
            .networkModule(NetworkModule())
            .build()
        applicationComponent.inject(application)
    }
}