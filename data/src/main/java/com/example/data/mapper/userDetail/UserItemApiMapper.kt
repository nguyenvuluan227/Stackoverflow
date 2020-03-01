package com.example.data.mapper.userDetail

import com.example.data.remote.model.userDetail.UserItemsApi
import com.example.domain.model.userDetail.UserItems
import javax.inject.Inject

class UserItemApiMapper @Inject constructor() {

    fun mapToDomain(api: UserItemsApi): UserItems {
        return UserItems(
            reputationHistoryType = api.reputationHistoryType,
            reputationChange = api.reputationChange,
            postId = api.postId,
            creationDate = api.creationDate,
            userId = api.userId
        )
    }
}