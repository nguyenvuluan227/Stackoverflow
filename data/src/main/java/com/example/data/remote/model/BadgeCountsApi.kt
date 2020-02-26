package com.example.data.remote.model

import com.google.gson.annotations.SerializedName

data class BadgeCountsApi(
    @SerializedName("bronze") val bronze: Int,
    @SerializedName("silver") val silver: Int,
    @SerializedName("gold") val gold: Int
)