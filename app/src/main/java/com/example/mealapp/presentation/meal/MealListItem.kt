package com.example.mealapp.presentation.meal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mealapp.domain.model.Meal

@Composable
fun MealListItem(
    meal: Meal,
    onClickItem: (String?) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onClickItem(meal.idMeal)
                       },
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {


        Row(modifier = Modifier.background(Color.White)) {

            Image(
                painter = rememberImagePainter(data = meal.strMealThumb),
                contentDescription = meal.strMeal,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .size(150.dp)
                    .width(50.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = meal.strMeal,
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}







