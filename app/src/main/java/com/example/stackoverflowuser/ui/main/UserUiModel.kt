package com.example.stackoverflowuser.ui.main

data class UserUiModel(
    val name: String,
    val avatar: String,
    val reputation: Int,
    val location: String,
    val isBookmarked: Boolean,
    val lastSeen: Long
)