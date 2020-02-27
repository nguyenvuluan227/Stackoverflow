package com.example.stackoverflow.di

import com.example.stackoverflow.activity.main.MainActivity
import com.example.stackoverflow.activity.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AppBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}