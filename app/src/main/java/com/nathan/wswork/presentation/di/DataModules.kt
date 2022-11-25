package com.nathan.wswork.presentation.di

import com.nathan.wswork.data.localdatasource.WSWDatabase
import com.nathan.wswork.domain.repository.WSWRepository
import com.nathan.wswork.data.repository.WSWRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModules = module {
    single{
        WSWDatabase.getInstance(androidContext())
    }
    factory <WSWRepository> {
        WSWRepositoryImpl(
            userDao = get<WSWDatabase>().userDao(),
            carDao = get<WSWDatabase>().carDao(),
            leadDao = get<WSWDatabase>().leadDao()
        )
    }
}