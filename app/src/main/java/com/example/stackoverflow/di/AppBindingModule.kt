package com.example.stackoverflow.di

import com.example.stackoverflow.MainActivity
import com.example.stackoverflow.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AppBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}