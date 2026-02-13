package com.example.remotemediator.view.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.remotemediator.data.local.MealEntity


@Composable
fun MealCard(entranceEntityMeal: MealEntity){

    Card(
        elevation= CardDefaults
            .cardElevation(8.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),

    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFcef5d8))
        ) {


            Column(
                modifier = Modifier
                    .padding(15.dp)

            ) {
                Text(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Name: ${entranceEntityMeal.strMeal}"
                )

                Text(
                    fontSize = 10.sp,
                    text = "Category: ${entranceEntityMeal.category}"
                )

                AsyncImage(
                    model = entranceEntityMeal.strMealThumb,
                    contentDescription = "Sample image",
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }

}