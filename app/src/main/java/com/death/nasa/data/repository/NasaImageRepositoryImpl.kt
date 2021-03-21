package com.death.nasa.data.repository

import com.death.nasa.data.model.NasaImage
import com.death.nasa.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class NasaImageRepositoryImpl @Inject constructor (private val networkService: NetworkService) : NasaImageRepository {
    override fun getNasaPhotos(): Single<List<NasaImage>> = networkService.getNasaImages()
}