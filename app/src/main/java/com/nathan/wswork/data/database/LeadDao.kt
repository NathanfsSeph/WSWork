package com.nathan.wswork.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.nathan.wswork.data.model.Lead

@Dao
interface LeadDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lead: Lead)

}