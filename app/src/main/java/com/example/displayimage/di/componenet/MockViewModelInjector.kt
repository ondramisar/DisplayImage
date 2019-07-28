package com.example.movieslist.di.componenet

import com.example.movieslist.di.module.MockRepositoryModule
import com.example.movieslist.ui.DisplayImageViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(MockRepositoryModule::class)])
interface MockViewModelInjector {

    fun inject(displayImageViewModel: DisplayImageViewModel)

    @Component.Builder
    interface Builder {
        fun build(): MockViewModelInjector

        fun repositoryModule(repositoryModule: MockRepositoryModule): Builder
    }
}