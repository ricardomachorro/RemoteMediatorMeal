package com.example.remotemediator.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.remotemediator.data.local.AppDatabase
import com.example.remotemediator.data.remote.TheMealDbApi
import com.example.remotemediator.view.main.MainViewModel

class MainViewModelFactory(
    private val api: TheMealDbApi,
    private val db: AppDatabase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(api, db) as T
        }
        throw IllegalArgumentException("Clase ViewModel desconocida")
    }



}