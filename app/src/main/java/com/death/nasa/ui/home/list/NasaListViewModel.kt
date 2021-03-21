package com.death.nasa.ui.home.list

import com.death.nasa.data.repository.NasaImageRepository
import com.death.nasa.ui.base.BaseViewModelImpl
import com.death.nasa.utils.rx.SchedulerProvider
import javax.inject.Inject

class NasaListViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    private val nasaImageRepository: NasaImageRepository
):BaseViewModelImpl<NasaListContract.ViewState, NasaListContract.ViewEvent>(schedulerProvider), NasaListContract {

    init {
        viewState = NasaListContract.ViewState()
    }

    override fun onViewCreated() {
        if(viewState.nasaImages.isEmpty() && viewState.loadStatus!=NasaListContract.LoadStatus.Error){
            fetchImages()
        }
    }

    private fun fetchImages(){
        nasaImageRepository.getNasaPhotos()
            .doOnSubscribe{
                viewState = viewState.copy(
                    loadStatus = NasaListContract.LoadStatus.Loading
                )
            }
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                       viewState = viewState.copy(
                           loadStatus = NasaListContract.LoadStatus.Loaded,
                           nasaImages = it
                       )
            }, {
                viewState = viewState.copy(
                    loadStatus = NasaListContract.LoadStatus.Error,
                    nasaImages = emptyList()
                )
            }).bindToLifecycle()
    }


    override fun process(viewEvent: NasaListContract.ViewEvent) {

    }
}