package com.nathan.wswork.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Car (
    val ano: Int,
    val combustivel: String,
    val cor: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val marca_id: Int,
    val marca_nome: String,
    val nome_modelo: String,
    val num_portas: Int,
    @ColumnInfo(name = "time_stamp_cadastro")
    val timestamp_cadastro: Int,
    val valor_fipe: Double
) : Parcelable