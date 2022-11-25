package com.nathan.wswork.data.remotedatasource

import com.nathan.wswork.domain.model.Lead
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