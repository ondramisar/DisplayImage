package com.example.movieslist.base

import com.example.movieslist.di.componenet.DaggerRepositoryInjector
import com.example.movieslist.di.componenet.RepositoryInjector
import com.example.movieslist.di.module.NetworkModule
import com.example.movieslist.network.ImageRepository

abstract class BaseRepository {
    private val injector: RepositoryInjector = DaggerRepositoryInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is ImageRepository -> injector.inject(this)
        }
    }
}