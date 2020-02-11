package com.example.stackoverflowuser.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
)

data class Item(
    @SerializedName("account_id")
    val accountId: Int,
    @SerializedName("last_access_date")
    @Expose
    val lastAccessDate: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("location")
    val location: String?,
    @SerializedName("profile_image")
    val profileImage: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("reputation")
    val reputation: Int
)