package com.example.movieslist.di.componenet

import com.example.movieslist.di.module.RepositoryModule
import com.example.movieslist.ui.DisplayImageViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(RepositoryModule::class)])
interface ViewModelInjector {

    fun inject(displayImageViewModel: DisplayImageViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun repositoryModule(repositoryModule: RepositoryModule): Builder
    }
}