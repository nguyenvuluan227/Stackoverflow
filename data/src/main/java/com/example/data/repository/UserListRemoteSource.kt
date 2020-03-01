package com.example.data.repository

import com.example.data.mapper.userDetail.UserDetailApiMapper
import com.example.data.mapper.userList.UserApiMapper
import com.example.data.remote.response.UserListService
import com.example.domain.model.userDetail.UserDetail
import com.example.domain.model.userList.User
import com.example.domain.repository.UserListRepository
import io.reactivex.Single
import javax.inject.Inject

class UserListRemoteSource @Inject constructor(
    private val userListService: UserListService,
    private val userApiMapper: UserApiMapper,
    private val userDetailApiMapper: UserDetailApiMapper
) : UserListRepository {

    override fun getListUser(page: Int, pageSize: Int, pageSite: String): Single<User> {
        return userListService.getUserList(page, pageSize, pageSite)
            .map { userApiMapper.mapToDomain(it) }
    }

    override fun getDetailUser(
        userId: Int,
        page: Int,
        pageSize: Int,
        site: String
    ): Single<UserDetail> {
        return userListService.getUserDetail(userId, page, pageSize, site)
            .map { userDetailApiMapper.mapToDomain(it) }
    }
}
