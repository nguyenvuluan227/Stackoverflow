package com.example.data.di

import com.example.data.repository.UserListRemoteSourceImp
import com.example.domain.repository.UserListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(userListRemoteSourceImp: UserListRemoteSourceImp): UserListRepository =
        userListRemoteSourceImp
}