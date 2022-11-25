package com.nathan.wswork.data.remotedatasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {

    private fun initRetrofit() : Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://www.wswork.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service : WSWDBService = initRetrofit().create(WSWDBService::class.java)
}