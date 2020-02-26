package com.example.domain

abstract class UseCase<in Params, out R> where R : Any {

    abstract fun createObservable(params: Params? = null): R

}