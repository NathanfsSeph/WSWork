package com.nathan.wswork.data.database

import com.nathan.wswork.data.model.Car
import com.nathan.wswork.data.model.Lead
import com.nathan.wswork.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WSWRepositoryImpl (private val userDao: UserDao, private val carDao: CarDao, private val leadDao: LeadDao) : WSWRepository {
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

    override suspend fun insertLead(lead: Lead) {
        withContext(Dispatchers.IO) {
            leadDao.insert(lead)
        }
    }

    override suspend fun getCars(): List<Car> {
        TODO("Not yet implemented")
    }
}