package com.example.data.remote.model

data class UserApi(
    val items: List<ItemApi>? = null,
    val hasMore: Boolean? = null,
    val quotaMax: Int? = null,
    val quotaRemaining: Int? = null
)