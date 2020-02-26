package com.example.data.mapper

import com.example.data.remote.model.UserApi
import com.example.domain.model.User
import javax.inject.Inject

class UserApiMapper @Inject constructor(private val itemApiMapper: ItemApiMapper) {

    fun mapToDomain(api: UserApi): User {
        return User(
            items = api.items?.map { itemApiMapper.mapToDomain(it) },
            hasMore = api.hasMore,
            quotaMax = api.quotaMax,
            quotaRemaining = api.quotaRemaining
        )
    }
}