package com.example.movieslist.di.module

import com.example.movieslist.network.IImageRepository
import com.example.movieslist.network.mock.ImageRepository
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