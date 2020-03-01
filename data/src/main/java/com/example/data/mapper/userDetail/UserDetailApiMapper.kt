package com.example.data.mapper.userDetail

import com.example.data.remote.model.userDetail.UserDetailApi
import com.example.domain.model.userDetail.UserDetail
import javax.inject.Inject

class UserDetailApiMapper @Inject constructor(private val userItemApiMapper: UserItemApiMapper) {

    fun mapToDomain(api: UserDetailApi): UserDetail {
        return UserDetail(
            userItems = api.userItemsApi.map { userItemApiMapper.mapToDomain(it) },
            hasMore = api.hasMore,
            quotaMax = api.quotaMax,
            quotaRemaining = api.quotaRemaining
        )
    }
}