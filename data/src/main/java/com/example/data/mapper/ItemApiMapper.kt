package com.example.data.mapper

import com.example.data.remote.model.ItemApi
import com.example.domain.model.Item
import javax.inject.Inject

class ItemApiMapper @Inject constructor(
    private val badgeCountsApiMapper: BadgeCountsApiMapper
) {
    fun mapToDomain(api: ItemApi): Item {
        return Item(
            badgeCounts = badgeCountsApiMapper.mapToDomain(api.badgeCounts!!),
            accountId = api.accountId,
            isEmployee = api.isEmployee,
            lastModifiedDate = api.lastModifiedDate,
            lastAccessDate = api.lastAccessDate,
            reputationChangeYear = api.reputationChangeYear,
            reputationChangeQuarter = api.reputationChangeQuarter,
            reputationChangeMonth = api.reputationChangeMonth,
            reputationChangeWeek = api.reputationChangeWeek,
            reputationChangeDay = api.reputationChangeDay,
            reputation = api.reputation,
            creationDate = api.creationDate,
            userType = api.userType,
            userId = api.userId,
            acceptRate = api.acceptRate,
            location = api.location,
            websiteUrl = api.websiteUrl,
            link = api.link,
            profileImage = api.profileImage,
            displayName = api.displayName
        )
    }
}