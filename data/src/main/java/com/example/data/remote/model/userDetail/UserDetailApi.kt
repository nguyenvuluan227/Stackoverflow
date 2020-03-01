package com.example.data.remote.model.userDetail

import com.google.gson.annotations.SerializedName

data class UserDetailApi(
    @SerializedName("items") val userItemsApi: List<UserItemsApi>,
    @SerializedName("has_more") val hasMore: Boolean,
    @SerializedName("quota_max") val quotaMax: Int,
    @SerializedName("quota_remaining") val quotaRemaining: Int
)