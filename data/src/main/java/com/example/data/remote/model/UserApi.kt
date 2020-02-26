package com.example.data.remote.model

data class UserApi(
    val items: List<ItemApi>,
    val hasMore: Boolean,
    val quotaMax: Int,
    val quotaRemaining: Int
)