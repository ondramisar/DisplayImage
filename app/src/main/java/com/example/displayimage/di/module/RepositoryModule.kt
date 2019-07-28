package com.example.movieslist.di.module

import com.example.movieslist.network.IImageRepository
import com.example.movieslist.network.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
object RepositoryModule {

    @Reusable
    @JvmStatic
    @Provides
    internal fun provideRepository(): IImageRepository {
        return ImageRepository()
    }
}