package com.example.movieslist.di.componenet

import com.example.movieslist.di.module.NetworkModule
import com.example.movieslist.network.ImageRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface RepositoryInjector {

    fun inject(imageRepository: ImageRepository)

    @Component.Builder
    interface Builder {
        fun build(): RepositoryInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}