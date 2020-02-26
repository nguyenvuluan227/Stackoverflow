package com.example.data.remote.model

import com.google.gson.annotations.SerializedName

data class BadgeCountsApi(
    @SerializedName("bronze") val bronze: Int? = null,
    @SerializedName("silver") val silver: Int? = null,
    @SerializedName("gold") val gold: Int? = null
)