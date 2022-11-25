package com.nathan.wswork.data.localdatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nathan.wswork.domain.model.Lead

@Dao
interface LeadDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lead: Lead)

    @Query("SELECT * FROM Lead")
    fun get(): List<Lead>

}