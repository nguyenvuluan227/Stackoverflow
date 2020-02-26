package com.example.domain.model

data class Item(
    val badgeCounts: BadgeCounts,
    val accountId: Int,
    val isEmployee: Boolean,
    val lastModifiedDate: Long,
    val lastAccessDate: Long,
    val reputationChangeYear: Int,
    val reputationChangeQuarter: Int,
    val reputationChangeMonth: Int,
    val reputationChangeWeek: Int,
    val reputationChangeDay: Int,
    val reputation: Long,
    val creationDate: Long,
    val userType: String,
    val userId: Int,
    val acceptRate: Int,
    val location: String,
    val websiteUrl: String,
    val link: String,
    val profileImage: String,
    val displayName: String
)