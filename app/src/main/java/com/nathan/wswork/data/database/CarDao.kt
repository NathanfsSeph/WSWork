package com.nathan.wswork.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nathan.wswork.data.model.Car
import com.nathan.wswork.data.model.Lead

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(car: Car)

    @Query("SELECT * FROM Car")
    fun get(): List<Car>

}