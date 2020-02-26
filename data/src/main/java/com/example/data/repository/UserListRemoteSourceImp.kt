package com.example.data.repository

import com.example.domain.model.User
import com.example.domain.repository.UserListRepository
import io.reactivex.Single
import javax.inject.Inject

class UserListRemoteSourceImp @Inject constructor(
    private val remoteSource: UserListRemoteSource
) : UserListRepository {
    override fun getListUser(page: Int, pageSize: Int): Single<User> {
        return remoteSource.getListUser(page, pageSize)
    }

}