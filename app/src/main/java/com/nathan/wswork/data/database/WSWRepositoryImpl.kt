package com.nathan.wswork.data.database

import com.nathan.wswork.data.model.Car
import com.nathan.wswork.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WSWRepositoryImpl (private val userDao: UserDao, ) : WSWRepository {
    override suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    override suspend fun insertCar(car: Car) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllCars(): List<Car> {
        TODO("Not yet implemented")
    }
}