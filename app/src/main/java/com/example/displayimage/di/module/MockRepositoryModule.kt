package com.example.displayimage.di.module

import com.example.displayimage.network.IImageRepository
import com.example.displayimage.network.mock.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
object MockRepositoryModule {

    @Reusable
    @JvmStatic
    @Provides
    internal fun provideMockRepository(): IImageRepository {
        return ImageRepository()
    }
}