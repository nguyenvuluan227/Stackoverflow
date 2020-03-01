package com.example.domain.model.userDetail

data class UserDetail(
    val userItems: List<UserItems>,
    val hasMore: Boolean,
    val quotaMax: Int,
    val quotaRemaining: Int
)