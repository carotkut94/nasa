package com.death.nasa.ui.base

/**
 * contract for main view model which will bind to MainActivitiy lifecycler
 */
interface MainContract: BaseViewModel<MainContract.ViewEvent> {
    class ViewState
    sealed class ViewEvent
}

