package com.nathan.wswork.presentation.di

import com.nathan.wswork.presentation.main.fragments.details.DetailsViewModel
import com.nathan.wswork.presentation.main.fragments.home.HomeViewModel
import com.nathan.wswork.presentation.main.fragments.login.LoginViewModel
import com.nathan.wswork.presentation.main.fragments.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModules = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel() }
    viewModel { UserViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}