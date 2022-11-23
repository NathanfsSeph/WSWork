package com.nathan.wswork.data.database

import com.nathan.wswork.data.model.Car
import com.nathan.wswork.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WSWRepositoryImpl (private val userDao: UserDao, private val carDao: CarDao) : WSWRepository {
    override suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    override suspend fun insertCar(car: Car) {
        withContext(Dispatchers.IO) {
            carDao.insert(car)
        }
    }

    override suspend fun getAllCars(): List<Car> {
        TODO("Not yet implemented")
    }
}