package com.nathan.wswork.presentation.di

import com.nathan.wswork.data.database.WSWDatabase
import com.nathan.wswork.data.database.WSWRepository
import com.nathan.wswork.data.database.WSWRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModules = module {
    single{
        WSWDatabase.getInstance(androidContext())
    }
    factory <WSWRepository> {
        WSWRepositoryImpl(
            userDao = get<WSWDatabase>().userDao()
        )
    }
}