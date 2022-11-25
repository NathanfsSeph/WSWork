package com.nathan.wswork.presentation.main.fragments.home

import com.nathan.wswork.domain.model.Car

data class HomeScreenState (
    val cars : List<Car>  = listOf()
)