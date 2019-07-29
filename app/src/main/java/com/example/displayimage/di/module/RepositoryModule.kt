package com.example.displayimage.di.module

import com.example.displayimage.network.IImageRepository
import com.example.displayimage.network.ImageRepository
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