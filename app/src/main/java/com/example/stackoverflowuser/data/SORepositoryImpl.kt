package com.example.stackoverflowuser.data

import com.example.stackoverflowuser.data.model.User
import com.example.stackoverflowuser.data.remote.SOService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SORepositoryImpl(private val service: SOService) : SORepository {

    override suspend fun getUsers(page: Int, pageSize: Int): List<User> = withContext(Dispatchers.IO) {
        service.getUsers(page, pageSize).items.map { it.toUser() }
    }

}