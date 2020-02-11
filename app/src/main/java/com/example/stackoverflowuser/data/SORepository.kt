package com.example.stackoverflowuser.data

import com.example.stackoverflowuser.data.model.User

interface SORepository {
    suspend fun getUsers(page: Int, pageSize: Int): List<User>
}