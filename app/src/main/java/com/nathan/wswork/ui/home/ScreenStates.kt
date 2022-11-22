package com.nathan.wswork.ui.home

import com.nathan.wswork.data.model.Car

data class HomeScreenState (
    val cars : List<Car>  = listOf()
)