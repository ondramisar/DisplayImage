package com.example.movieslist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieslist.ui.DisplayImageViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DisplayImageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DisplayImageViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}