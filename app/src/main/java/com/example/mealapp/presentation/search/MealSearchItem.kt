package com.example.mealapp.presentation.search

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
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mealapp.domain.model.Meal
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealSearchItem(meal: Meal, onClickItem: (String?) -> Unit) {

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


        Row(modifier = Modifier.background(Color.White), verticalAlignment = Alignment.Bottom) {

            Image(
                painter = rememberImagePainter(data = meal.strMealThumb),
                contentDescription = meal.strMeal,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .size(100.dp)
                    .width(50.dp)
                    .clip(RoundedCornerShape(16.dp))
            )



            Text(
                text = meal.strMeal.orEmpty(),
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 13.dp, bottom = 60.dp)
            )
        }
    }
}