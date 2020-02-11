package com.example.stackoverflowuser.data.model

data class User(
    val id: String,
    val name: String,
    val avatar: String,
    val reputation: Int,
    val location: String,
    val lastAccess: Long
)