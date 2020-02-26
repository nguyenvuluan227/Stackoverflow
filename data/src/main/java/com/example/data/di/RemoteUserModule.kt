package com.example.data.di

import com.example.data.remote.response.UserListService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RemoteUserModule {

    @Provides
    @Singleton
    fun provideUserListService(retrofit: Retrofit): UserListService {
        return retrofit.create(UserListService::class.java)
    }
}