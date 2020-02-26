package com.example.domain.repository

import com.example.domain.model.User
import io.reactivex.Single

interface UserListRepository {
    fun getListUser(page: Int, pageSize: Int, pageSite: String): Single<User>
}