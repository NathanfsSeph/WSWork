package com.nathan.wswork.domain.repository

import com.nathan.wswork.domain.model.Car
import com.nathan.wswork.domain.model.Lead
import com.nathan.wswork.domain.model.User

interface WSWRepository {
    suspend fun insertUser(user: User)

    suspend fun getUser(email: String, password: String) : User

    suspend fun insertCar(car : Car)

    suspend fun insertLead(lead: Lead)

    suspend fun getLeads() : List<Lead>

    suspend fun getCars() : List<Car>
}