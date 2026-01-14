package com.example.remotemediator.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MealDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertAll(meal: List<MealEntity>)

    @Query("SELECT * FROM meals WHERE category = :category")
    fun getMealsByCategory(category:String): PagingSource<Int, MealEntity>

    @Query("DELETE FROM meals WHERE category = :category")
    suspend fun clearByCategory(category: String)




}