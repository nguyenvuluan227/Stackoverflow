package com.example.data.repository

import com.example.data.mapper.UserApiMapper
import com.example.data.remote.response.UserListService
import com.example.domain.model.User
import com.example.domain.repository.UserListRepository
import io.reactivex.Single
import javax.inject.Inject

class UserListRemoteSource @Inject constructor(
    private val userListService: UserListService,
    private val userApiMapper: UserApiMapper
) :
    UserListRepository {
    override fun getListUser(page: Int, pageSize: Int, pageSite: String): Single<User> {
        return userListService.getUserList(page, pageSize, pageSite).map {
            userApiMapper.mapToDomain(it)
        }
    }

}