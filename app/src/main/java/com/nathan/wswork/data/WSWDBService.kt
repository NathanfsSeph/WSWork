package com.nathan.wswork.data

import com.nathan.wswork.data.model.Lead
import com.nathan.wswork.data.response.CarsBodyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WSWDBService {
    @GET("cars.json")
    fun getCars(): Call<CarsBodyResponse>

    @POST("cars/leads/")
    fun sendLeads(@Body leads: List<Lead>): Call<List<Lead>>

}