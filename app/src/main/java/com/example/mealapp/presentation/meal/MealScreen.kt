package com.example.mealapp.presentation.meal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
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

        Button(onClick = {
            navController.navigate("meal_search_screen")
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            , modifier = Modifier
                .padding(10.dp)
                .background(Color.White, CircleShape)) {
            Icon(
                imageVector = Icons.Default.Search,
                modifier = Modifier.size(24.dp),
                contentDescription = "drawable icons",
                tint = Color.Black
            )
            Text(
                text = "Search",
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .offset(x = 40.dp / 5)
            )
        }


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
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
        }
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
