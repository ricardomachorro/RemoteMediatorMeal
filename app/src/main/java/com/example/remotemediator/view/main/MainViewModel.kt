package com.example.remotemediator.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.remotemediator.data.local.AppDatabase
import com.example.remotemediator.data.mediator.MealRemoteMediator
import com.example.remotemediator.data.remote.TheMealDbApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class MainViewModel(private val api: TheMealDbApi, private val db: AppDatabase): ViewModel() {

    private val _selectedCategory = MutableStateFlow("Beef")
    val selectedCategory = _selectedCategory.asStateFlow()
    @OptIn(ExperimentalCoroutinesApi::class, ExperimentalPagingApi::class)
    val mealsFlow = _selectedCategory.flatMapLatest { category ->
        Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MealRemoteMediator(category, api, db),
            pagingSourceFactory = { db.mealDao().getMealsByCategory(category) }
        ).flow
    }.cachedIn(viewModelScope)

    fun updateCategory(newCategory: String) {
        _selectedCategory.value = newCategory
    }

    suspend fun getCategories():List<String>{

        var categoriesList =  mutableListOf("")

        categoriesList = api.getCategories().meals?.map{ it.strCategory} as MutableList<String>

        return categoriesList
    }



}