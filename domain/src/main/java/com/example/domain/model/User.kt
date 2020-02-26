package com.example.domain.model

data class User(
    val items: List<Item>,
    val hasMore: Boolean,
    val quotaMax: Int,
    val quotaRemaining: Int
)