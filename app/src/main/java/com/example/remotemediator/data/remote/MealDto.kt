package com.example.remotemediator.data.remote

import com.google.gson.annotations.SerializedName

data class MealDto(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strMealThumb") val strMealThumb: String
)
