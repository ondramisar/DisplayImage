package com.example.displayimage.base

import androidx.lifecycle.ViewModel
import com.example.displayimage.di.componenet.DaggerMockViewModelInjector
import com.example.displayimage.di.componenet.DaggerViewModelInjector
import com.example.displayimage.di.componenet.MockViewModelInjector
import com.example.displayimage.di.componenet.ViewModelInjector
import com.example.displayimage.di.module.MockRepositoryModule
import com.example.displayimage.di.module.RepositoryModule
import com.example.displayimage.ui.DisplayImageViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .repositoryModule(RepositoryModule)
        .build()

    private val injectorMock: MockViewModelInjector = DaggerMockViewModelInjector
        .builder()
        .repositoryModule(MockRepositoryModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is DisplayImageViewModel -> injector.inject(this)
        }
    }
}