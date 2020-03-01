package com.example.domain.model.userDetail

data class UserItems(
    val reputationHistoryType: String,
    val reputationChange: Int,
    val postId: Long,
    val creationDate: Long,
    val userId: Int
)