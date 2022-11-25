package com.nathan.wswork.data.repository

import com.nathan.wswork.data.localdatasource.CarDao
import com.nathan.wswork.data.localdatasource.LeadDao
import com.nathan.wswork.data.localdatasource.UserDao
import com.nathan.wswork.domain.model.Car
import com.nathan.wswork.domain.model.Lead
import com.nathan.wswork.domain.model.User
import com.nathan.wswork.domain.repository.WSWRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WSWRepositoryImpl (private val userDao: UserDao, private val carDao: CarDao, private val leadDao: LeadDao) :
    WSWRepository {

    override suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    override suspend fun getUser(email: String, password: String): User = withContext(Dispatchers.IO) {
        return@withContext userDao.get(email, password)
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