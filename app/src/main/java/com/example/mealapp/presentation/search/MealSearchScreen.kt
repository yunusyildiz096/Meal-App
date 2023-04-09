package com.example.mealapp.presentation.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mealapp.domain.model.Meal

@Composable
fun MealSearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val search = viewModel.state.value
    Column(modifier = Modifier.fillMaxSize()) {


        var text by remember { mutableStateOf("") }




            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                    viewModel.mealSearch(it)},

                label = { Text(text = "Search Meal...")},
                modifier = Modifier.fillMaxWidth()
                        /*
                    .border(
                        BorderStroke(
                            width = 2.dp,
                            color = MaterialTheme.colors.surface
                        ),
                    )

                         */
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clip(CircleShape)

            )

        if (search.isLoading){
            CircularProgressIndicator()
        }
        if (search.error.isNotBlank()) {
            Text(
                text = search.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)

            )
        }


            Spacer(modifier = Modifier.height(6.dp))

        MealList(search = search.search)

    }
}

@Composable
fun MealList(search: List<Meal>) {
    LazyColumn(contentPadding = PaddingValues(10.dp)) {
        items(search) {
            MealSearchItem(meal = it)
            println(search)
        }
    }
}

