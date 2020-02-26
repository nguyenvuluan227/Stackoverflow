package com.example.domain.model

data class Item(
    val badgeCounts: BadgeCounts? = null,
    val accountId: Int? = null,
    val isEmployee: Boolean? = null,
    val lastModifiedDate: Long? = null,
    val lastAccessDate: Long? = null,
    val reputationChangeYear: Int? = null,
    val reputationChangeQuarter: Int? = null,
    val reputationChangeMonth: Int? = null,
    val reputationChangeWeek: Int? = null,
    val reputationChangeDay: Int? = null,
    val reputation: Long? = null,
    val creationDate: Long? = null,
    val userType: String? = null,
    val userId: Int? = null,
    val acceptRate: Int? = null,
    val location: String? = null,
    val websiteUrl: String? = null,
    val link: String? = null,
    val profileImage: String? = null,
    val displayName: String? = null
)