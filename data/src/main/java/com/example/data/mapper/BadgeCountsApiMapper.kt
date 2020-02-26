package com.example.data.mapper

import com.example.data.remote.model.BadgeCountsApi
import com.example.domain.model.BadgeCounts
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