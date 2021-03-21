package com.death.nasa.data.repository

import com.death.nasa.data.model.NasaImage
import io.reactivex.Single

interface NasaImageRepository{
    fun getNasaPhotos(): Single<List<NasaImage>>
}