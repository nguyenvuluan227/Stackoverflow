package com.example.stackoverflow.di

import com.example.base.di.PerActivity
import com.example.stackoverflow.activity.detail.DetailActivity
import com.example.stackoverflow.activity.detail.DetailModule
import com.example.stackoverflow.activity.main.MainActivity
import com.example.stackoverflow.activity.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AppBindingModule {


    @PerActivity
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun detailActivity(): DetailActivity
}