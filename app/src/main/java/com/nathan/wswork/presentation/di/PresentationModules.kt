package com.nathan.wswork.presentation.di

import org.koin.dsl.module

val dataModules = module {
    single{
        // Instanciar um singleton, olhar o projeto do tokenlab
    }
    factory {
        // Instanciar uma nova instancia, olhar o projeto do tokenlab
    }
}