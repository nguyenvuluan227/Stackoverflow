package com.example.data.remote.model.userList

import com.google.gson.annotations.SerializedName

data class UserApi(
    @SerializedName("items") val items: List<ItemApi>? = null,
    @SerializedName("has_more") val hasMore: Boolean? = null,
    @SerializedName("quota_max") val quotaMax: Int? = null,
    @SerializedName("quota_remaining") val quotaRemaining: Int? = null
)