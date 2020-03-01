package com.example.data.mapper.userList

import com.example.data.remote.model.userList.BadgeCountsApi
import com.example.domain.model.userList.BadgeCounts
import javax.inject.Inject

class BadgeCountsApiMapper @Inject constructor() {

    fun mapToDomain(api: BadgeCountsApi): BadgeCounts {
        return BadgeCounts(
            bronze = api.bronze,
            silver = api.silver,
            gold = api.gold
        )
    }
}