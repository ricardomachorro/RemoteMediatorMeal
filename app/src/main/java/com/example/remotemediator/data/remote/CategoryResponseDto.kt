package com.example.remotemediator.data.remote

import com.google.gson.annotations.SerializedName

data class CategoryResponseDto(
    @SerializedName("meals") val meals: List<CategoryDto>?
)
