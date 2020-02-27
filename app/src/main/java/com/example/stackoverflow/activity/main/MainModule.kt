package com.example.stackoverflow.activity.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.base.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ActivityContext
    fun provideActivityContext(activity: MainActivity): Context = activity

    @Provides
    fun provideViewModel(
        activity: MainActivity,
        factory: UserListViewModelFactory
    ): UserListViewModel {
        return ViewModelProvider(activity, factory)
            .get(UserListViewModel::class.java)
    }
}