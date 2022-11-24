package com.nathan.wswork.data.database

import com.nathan.wswork.data.model.Car
import com.nathan.wswork.data.model.Lead
import com.nathan.wswork.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class WSWRepositoryImpl (private val userDao: UserDao, private val carDao: CarDao, private val leadDao: LeadDao) : WSWRepository {

    override suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    override suspend fun getUser(userId: Int): User = withContext(Dispatchers.IO) {
        return@withContext userDao.get(userId)
    }

    override suspend fun insertCar(car: Car) {
        withContext(Dispatchers.IO) {
            carDao.insert(car)
        }
    }

    override suspend fun getCars(): List<Car> = withContext(Dispatchers.IO) {
        return@withContext carDao.get()
    }

    override suspend fun insertLead(lead: Lead) {
        withContext(Dispatchers.IO) {
            leadDao.insert(lead)
        }
    }

    override suspend fun getLeads(): List<Lead> = withContext(Dispatchers.IO) {
        return@withContext leadDao.get()
    }

}