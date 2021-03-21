package com.death.nasa.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.death.nasa.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class BaseViewModelImpl<State, Event>(
    protected val schedulerProvider: SchedulerProvider
) : ViewModel(), BaseViewModel<Event> {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    private val _viewStates: MutableLiveData<State> = MutableLiveData()
    fun viewStates(): LiveData<State> = _viewStates

    private var _viewState: State? = null
    protected var viewState: State
        get() = _viewState
            ?: throw UninitializedPropertyAccessException("\"viewState\" was queried before being initialized")
        set(value) {
            Timber.d("setting viewState : $value")
            _viewState = value
            _viewStates.postValue(value)
        }


    protected fun Disposable.bindToLifecycle() = apply {
        compositeDisposable.add(this)
    }
}