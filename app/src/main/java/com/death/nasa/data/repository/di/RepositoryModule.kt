package com.death.nasa.data.repository.di

import com.death.nasa.data.repository.NasaImageRepository
import com.death.nasa.data.repository.NasaImageRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNasaImageRepository(nasaImageRepositoryImpl: NasaImageRepositoryImpl) : NasaImageRepository = nasaImageRepositoryImpl
}