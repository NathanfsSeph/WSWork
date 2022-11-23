package com.nathan.wswork.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.nathan.wswork.data.model.Car

@Dao
interface CarDao {

    @Insert
    fun insert(car: Car)

}