package com.nathan.wswork.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Car (
    val ano: Int,
    val combustivel: String,
    val cor: String,
    val id: Int,
    val marca_id: Int,
    val marca_nome: String,
    val nome_modelo: String,
    val num_portas: Int,
    @ColumnInfo(name = "time_stamp_cadastro")
    val timestamp_cadastro: Int,
    val valor_fipe: Double
)