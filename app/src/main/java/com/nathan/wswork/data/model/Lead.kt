package com.nathan.wswork.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lead (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "car_id")
    val carId: Int,
    @ColumnInfo(name = "user_name")
    var userName: String,
    @ColumnInfo(name = "user_phone")
    val userPhone: String
)