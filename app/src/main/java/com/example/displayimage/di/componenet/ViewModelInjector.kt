package com.example.displayimage.di.componenet

import com.example.displayimage.di.module.RepositoryModule
import com.example.displayimage.ui.DisplayImageViewModel
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