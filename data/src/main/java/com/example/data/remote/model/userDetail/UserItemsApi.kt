package com.example.data.remote.model.userDetail

import com.google.gson.annotations.SerializedName

data class UserItemsApi(
    @SerializedName("reputation_history_type") val reputationHistoryType: String,
    @SerializedName("reputation_change") val reputationChange: Int,
    @SerializedName("post_id") val postId: Long,
    @SerializedName("creation_date") val creationDate: Long,
    @SerializedName("user") val userId: Int
)