package com.example.remotemediator.data.remote

import MealsResponseDto
import android.icu.util.ULocale
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMealDbApi {

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ): MealsResponseDto

    @GET("list.php")
    suspend fun getCategories(
        @Query("c") option: String = "list"
    ): CategoryResponseDto


    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }




}