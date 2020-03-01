package com.example.domain.repository

import com.example.domain.model.userDetail.UserDetail
import com.example.domain.model.userList.User
import io.reactivex.Single

interface UserListRepository {
    fun getListUser(page: Int, pageSize: Int, pageSite: String): Single<User>

    fun getDetailUser(userId: Int, page: Int, pageSize: Int, site: String): Single<UserDetail>
}