package com.example.remotemediator.data.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.remotemediator.data.local.AppDatabase
import com.example.remotemediator.data.local.MealEntity
import com.example.remotemediator.data.remote.TheMealDbApi

@OptIn(ExperimentalPagingApi::class)
class MealRemoteMediator(
    private val category: String,
    private val api: TheMealDbApi,
    private val db: AppDatabase
) : RemoteMediator<Int, MealEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MealEntity>
    ):MediatorResult{
        return try {


            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            }

            if (loadType == LoadType.REFRESH) {
                val response = api.getMealsByCategory(category)
                val meals = response.meals?.map {
                    MealEntity(it.idMeal, it.strMeal, it.strMealThumb, category)
                } ?: emptyList()

                db.withTransaction {
                    // Limpiamos solo la categoría actual para no borrar todo lo demás
                    db.mealDao().clearByCategory(category)
                    db.mealDao().insertAll(meals)
                }
            }

            MediatorResult.Success(endOfPaginationReached = true)
        } catch (e:Exception){
            MediatorResult.Error(e)
        }
    }
}