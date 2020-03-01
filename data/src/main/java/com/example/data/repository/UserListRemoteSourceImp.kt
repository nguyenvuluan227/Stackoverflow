package com.example.data.repository

import com.example.domain.model.userDetail.UserDetail
import com.example.domain.model.userList.User
import com.example.domain.repository.UserListRepository
import io.reactivex.Single
import javax.inject.Inject

class UserListRemoteSourceImp @Inject constructor(
    private val remoteSource: UserListRemoteSource
) : UserListRepository {
    override fun getListUser(page: Int, pageSize: Int, pageSite: String): Single<User> {
        return remoteSource.getListUser(page, pageSize, pageSite)
    }

    override fun getDetailUser(
        userId: Int,
        page: Int,
        pageSize: Int,
        site: String
    ): Single<UserDetail> {
        return remoteSource.getDetailUser(userId, page, pageSize, site)
    }

}