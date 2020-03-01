package com.example.stackoverflow.activity.detail

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.base.di.ActivityContext
import com.example.base.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class DetailModule {

    @Provides
    @PerActivity
    @ActivityContext
    fun provideActivityContext(activity: DetailActivity): Context = activity

    @Provides
    @PerActivity
    fun provideViewModel(
        activity: DetailActivity,
        factory: UserDetailViewModelFactory
    ): UserDetailViewModel {
        return ViewModelProvider(activity, factory)
            .get(UserDetailViewModel::class.java)
    }
}