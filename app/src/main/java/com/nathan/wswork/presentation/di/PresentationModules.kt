package com.nathan.wswork.presentation.di

import com.nathan.wswork.ui.details.DetailsViewModel
import com.nathan.wswork.ui.home.HomeViewModel
import com.nathan.wswork.ui.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModules = module {
    viewModel {
        HomeViewModel()
        DetailsViewModel()
        UserViewModel(get())
    }
}