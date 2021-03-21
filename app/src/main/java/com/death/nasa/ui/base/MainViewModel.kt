package com.death.nasa.ui.base

import com.death.nasa.utils.rx.SchedulerProvider
import javax.inject.Inject

class MainViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
) : BaseViewModelImpl<MainContract.ViewState, MainContract.ViewEvent>(schedulerProvider), MainContract {

    override fun onViewCreated() {

    }

    override fun process(viewEvent: MainContract.ViewEvent) {

    }

}