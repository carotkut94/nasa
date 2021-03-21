package com.death.nasa.data.remote.di


import com.death.nasa.data.remote.NetworkService
import com.death.nasa.data.remote.Networking
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule{

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
    ): NetworkService = Networking.create(baseUrl)

}