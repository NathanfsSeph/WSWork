package com.nathan.wswork.data.database

import com.nathan.wswork.data.model.Car
import com.nathan.wswork.data.model.Lead
import com.nathan.wswork.data.model.User

interface WSWRepository {
    suspend fun insertUser(user: User)

    suspend fun getUser(userId: Int) : User

    suspend fun insertCar(car : Car)

    suspend fun insertLead(lead: Lead)

    suspend fun getLeads() : List<Lead>

    suspend fun getCars() : List<Car>
}