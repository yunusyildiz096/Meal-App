package com.example.mealapp.presentation.meal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MealScreen(
    viewModel: MealViewModel = hiltViewModel(),
    navController: NavController,
    navigateToMealDetail: (String?) -> Unit
){
    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()){

        Spacer(modifier = Modifier.height(5.dp))
        
        LazyColumn(contentPadding = PaddingValues(10.dp)){
            items(state.meals){item ->
                MealListItem(meal = item,
                    onClickItem = {
                        navigateToMealDetail(it)
                    }
                )
            }
        }
    }

    if (state.error.isNotBlank()){
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        )
    }
    if (state.isLoading){
        CircularProgressIndicator()
    }

}

@Composable
fun SearchBar(){

    var text by remember { mutableStateOf(TextFieldValue()) }

    Column( modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it},
            label = { Text(text = "Search Meal...")},
            modifier = Modifier.fillMaxWidth()
                .border(
                    BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colors.surface
                    ),
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clip(CircleShape)

        )


    }
}
