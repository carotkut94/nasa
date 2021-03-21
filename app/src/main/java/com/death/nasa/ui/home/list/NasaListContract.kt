package com.death.nasa.ui.home.list

import com.death.nasa.data.model.NasaImage
import com.death.nasa.ui.base.BaseViewModel

interface NasaListContract: BaseViewModel<NasaListContract.ViewEvent> {

    data class ViewState(val loadStatus: LoadStatus=LoadStatus.Loading,
                             val nasaImages: List<NasaImage> = emptyList())

    sealed class LoadStatus {
        object Loading : LoadStatus()
        object Loaded : LoadStatus()
        object Error : LoadStatus()
    }

    sealed class ViewEvent
}