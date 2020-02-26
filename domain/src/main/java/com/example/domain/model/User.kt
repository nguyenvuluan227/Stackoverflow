package com.example.domain.model

data class User(
    val items: List<Item>? = null,
    val hasMore: Boolean? = null,
    val quotaMax: Int? = null,
    val quotaRemaining: Int? = null
)