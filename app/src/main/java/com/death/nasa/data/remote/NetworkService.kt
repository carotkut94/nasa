package com.death.nasa.data.remote

import com.death.nasa.data.model.NasaImage
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService{

    @GET(Endpoints.NASA_IMAGES)
    fun getNasaImages():Single<List<NasaImage>>
}