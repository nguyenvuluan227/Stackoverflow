package com.example.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseViewModel<S> : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    val state: MutableLiveData<S> = MutableLiveData()

    abstract fun initState(): S

    protected fun state() = state.value ?: initState()

    protected fun setState(block: S.() -> S) {
        state.value = block(state.value ?: initState())
    }

    protected fun Disposable.addToDisposables() {
        this.addTo(disposable)
    }
}