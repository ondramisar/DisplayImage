package com.example.displayimage.di.componenet

import com.example.displayimage.di.module.NetworkModule
import com.example.displayimage.network.ImageRepository
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