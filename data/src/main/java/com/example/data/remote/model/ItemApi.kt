package com.example.data.remote.model

import com.google.gson.annotations.SerializedName

data class ItemApi(
    @SerializedName("badge_counts") val badgeCounts: BadgeCountsApi? = null,
    @SerializedName("account_id") val accountId: Int? = null,
    @SerializedName("is_employee") val isEmployee: Boolean? = null,
    @SerializedName("last_modified_date") val lastModifiedDate: Long? = null,
    @SerializedName("last_access_date") val lastAccessDate: Long? = null,
    @SerializedName("reputation_change_year") val reputationChangeYear: Int? = null,
    @SerializedName("reputation_change_quarter") val reputationChangeQuarter: Int? = null,
    @SerializedName("reputation_change_month") val reputationChangeMonth: Int? = null,
    @SerializedName("reputation_change_week") val reputationChangeWeek: Int? = null,
    @SerializedName("reputation_change_day") val reputationChangeDay: Int? = null,
    @SerializedName("reputation") val reputation: Long? = null,
    @SerializedName("creation_date") val creationDate: Long? = null,
    @SerializedName("user_type") val userType: String? = null,
    @SerializedName("user_id") val userId: Int? = null,
    @SerializedName("accept_rate") val acceptRate: Int? = null,
    @SerializedName("location") val location: String? = null,
    @SerializedName("website_url") val websiteUrl: String? = null,
    @SerializedName("link") val link: String? = null,
    @SerializedName("profile_image") val profileImage: String? = null,
    @SerializedName("display_name") val displayName: String? = null
)