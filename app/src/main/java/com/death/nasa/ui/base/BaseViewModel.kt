package com.death.nasa.ui.base

interface BaseViewModel<Event>{
    fun onViewCreated()
    fun process(viewEvent: Event)
}