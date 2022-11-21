package com.nathan.wswork.data.database

import com.nathan.wswork.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WSWRepositoryImpl (private val dao: UserDao) : WSWRepository {
    override suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            dao.insert(user)
        }
    }
}