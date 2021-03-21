package com.death.nasa.ui.home.list.item

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.death.nasa.BR

class NasaListBindingModel:BaseObservable() {

    @get:Bindable
    var loading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    @get:Bindable
    var showError: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.showError)
        }

}