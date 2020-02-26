package com.example.base

class Event<D>(private val data: D) {

    private var hasBeenHandled = false


    private fun getDataIfNotHandled(): D? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            data
        }
    }


    fun peekData(): D = data

    fun get(blockHandleEvent: D.() -> Unit) {
        getDataIfNotHandled()?.let { blockHandleEvent(it) }
    }
}
