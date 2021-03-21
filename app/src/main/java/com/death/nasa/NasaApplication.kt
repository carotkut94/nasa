package com.death.nasa

import android.app.Application
import com.death.nasa.di.injector.ApplicationInjector
import timber.log.Timber

class NasaApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        ApplicationInjector.inject(this)
        plantTimber()
    }

    private fun plantTimber(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}