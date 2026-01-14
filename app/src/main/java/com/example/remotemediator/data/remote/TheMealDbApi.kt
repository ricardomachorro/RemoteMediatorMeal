package com.example.remotemediator.data.remote

import MealsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMealDbApi {

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ): MealsResponseDto

    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }


}