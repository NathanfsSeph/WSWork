package com.nathan.wswork.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nathan.wswork.data.model.Lead
import retrofit2.Call
import retrofit2.http.GET

@Dao
interface LeadDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lead: Lead)

    @Query("SELECT * FROM Lead")
    fun get(): List<Lead>

}