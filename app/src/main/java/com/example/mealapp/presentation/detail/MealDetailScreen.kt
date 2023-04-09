package com.example.mealapp.presentation.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MealDetailScreen(
    viewModel: MealDetailViewModel = hiltViewModel()
) {


    val state = viewModel.state.value

    state.data?.let {
        Text(text = it.strMeal, color = MaterialTheme.colors.secondary)
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