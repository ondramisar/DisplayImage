package com.example.displayimage.base

import com.example.displayimage.di.componenet.DaggerRepositoryInjector
import com.example.displayimage.di.componenet.RepositoryInjector
import com.example.displayimage.di.module.NetworkModule
import com.example.displayimage.network.ImageRepository

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