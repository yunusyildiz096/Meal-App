package com.example.mealapp.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mealapp.R
import com.example.mealapp.navigation.Screen

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealDetailScreen(
    viewModel: DetailFoodViewModel = hiltViewModel(),
    navController: NavController
) {

    val state = viewModel.state.value


    Column(modifier = Modifier.fillMaxSize()) {
        state.data.let { data ->
            if (data.isNotEmpty()) {

                DetailTopBar(mealName = data[0]?.strMeal.orEmpty(), navController)

                Image(
                    painter = rememberImagePainter(data = data[0]?.strMealThumb),
                    contentDescription = null, modifier = Modifier.fillMaxWidth()
                )


                Spacer(modifier = Modifier.padding(15.dp))

                val ingredients = listOf(
                    data[0]?.strIngredient1.orEmpty(),
                    data[0]?.strIngredient2.orEmpty(),
                    data[0]?.strIngredient3.orEmpty(),
                    data[0]?.strIngredient4.orEmpty(),
                    data[0]?.strIngredient5.orEmpty(),
                    data[0]?.strIngredient6.orEmpty(),
                    data[0]?.strIngredient7.orEmpty(),
                    data[0]?.strIngredient8.orEmpty(),
                    data[0]?.strIngredient9.orEmpty(),
                    data[0]?.strIngredient10.orEmpty(),
                    data[0]?.strIngredient11.orEmpty(),
                    data[0]?.strIngredient12.orEmpty(),
                    data[0]?.strIngredient13.orEmpty(),
                    data[0]?.strIngredient14.orEmpty(),
                    data[0]?.strIngredient15.orEmpty(),
                    data[0]?.strIngredient16.orEmpty(),
                    data[0]?.strIngredient17.orEmpty(),
                    data[0]?.strIngredient18.orEmpty(),
                    data[0]?.strIngredient19.orEmpty(),
                    data[0]?.strIngredient20.orEmpty()
                )
                Text(
                    text = "Ingredients",
                    color = MaterialTheme.colors.secondary,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                LazyColumn {
                    items(ingredients) {
                        Text(
                            text = it,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
    }

    if (state.isLoading) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(
                    start = 150.dp, top = 150.dp,
                    end = 150.dp,
                    bottom = 300.dp
                ), color = MaterialTheme.colors.secondary
        )
    }

    if (state.error.isNotBlank()) {
        Text(text = state.error, color = Color.Black)
    }
}


        






