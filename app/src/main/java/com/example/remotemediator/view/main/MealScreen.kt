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
import com.example.remotemediator.view.general.MealCard


@Composable
fun MealScreen(viewModel: MainViewModel){

    val meals = viewModel.mealsFlow.collectAsLazyPagingItems();
    val selectedCategory by viewModel.selectedCategory.collectAsState()

    val categories = listOf("Beef", "Chicken", "Dessert", "Pasta", "Seafood")


    Column(
        modifier = Modifier
            .padding(vertical = 90.dp)
    ){

        LazyRow(modifier =  Modifier.padding(vertical = 8.dp, horizontal = 24.dp)) {

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

        LazyColumn(modifier =
            Modifier.padding(vertical = 8.dp,horizontal = 15.dp)) {
            items(meals.itemCount){
                index ->
                val meal = meals[index]
                meal?.let{

                    MealCard(it)
                }
            }
        }

    }



}