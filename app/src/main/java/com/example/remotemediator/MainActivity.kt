package com.example.remotemediator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.remotemediator.data.local.AppDatabase
import com.example.remotemediator.data.remote.TheMealDbApi
import com.example.remotemediator.view.MainViewModelFactory
import com.example.remotemediator.view.main.MainViewModel
import com.example.remotemediator.view.main.MealScreen
import com.example.remotemediator.view.other.AppContainer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = AppContainer(this)


        val factory = MainViewModelFactory(appContainer.retrofit, appContainer.database)
        val viewModel: MainViewModel by viewModels { factory }


        enableEdgeToEdge()
        setContent {



            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llamamos a tu pantalla principal
                    MealScreen(viewModel = viewModel)
                }
            }
        }
    }
}

