package com.example.remotemediator.view.other

import android.content.Context
import com.example.remotemediator.data.local.AppDatabase
import com.example.remotemediator.data.remote.TheMealDbApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {

     val retrofit = Retrofit.Builder()
        .baseUrl(TheMealDbApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TheMealDbApi::class.java)

     val database = AppDatabase.build(context)

}