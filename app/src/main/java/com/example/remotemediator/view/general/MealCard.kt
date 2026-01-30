package com.example.remotemediator.view.general

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remotemediator.data.local.MealEntity


@Composable
fun MealCard(entranceEntityMeal: MealEntity){

    Card(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),

    ) {

        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                text = entranceEntityMeal.strMeal
            )

            Text(
                fontSize = 10.sp,
                text = entranceEntityMeal.category
            )
        }
    }

}