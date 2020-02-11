package com.example.stackoverflowuser.data

import com.example.stackoverflowuser.data.model.User
import com.example.stackoverflowuser.data.remote.response.Item

fun Item.toUser() = User(
    id = userId.toString(),
    name = displayName,
    avatar = profileImage,
    reputation = reputation,
    location = location.orEmpty(),
    lastAccess = lastAccessDate.toLong()
)