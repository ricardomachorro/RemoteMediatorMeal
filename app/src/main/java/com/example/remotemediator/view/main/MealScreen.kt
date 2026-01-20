package com.example.remotemediator.view.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems


@Composable
fun MealScreen(viewModel: MainViewModel){

    val meals = viewModel.mealsFlow.collectAsLazyPagingItems();
    val selectedCategory by viewModel.selectedCategory.collectAsState()

    val categories = listOf("Beef", "Chicken", "Dessert", "Pasta", "Seafood")


    Column{

        LazyRow(modifier =  Modifier.padding(8.dp)) {

              items(categories){
                    category ->
                  Button(
                      onClick = { viewModel.updateCategory(category) },
                      modifier = Modifier.padding(4.dp),
                      colors = ButtonDefaults.buttonColors(
                          containerColor = if (category == selectedCategory) Color.DarkGray else Color.Gray
                      )
                  ) {
                      Text(category)
                  }
              }
        }

        LazyColumn {
            items(meals.itemCount){
                index ->
                val meal = meals[index]
                meal?.let{
                    Text(text = it.strMeal, modifier = Modifier.padding(16.dp))
                }
            }
        }

    }



}