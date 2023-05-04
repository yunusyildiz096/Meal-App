package com.example.mealapp.presentation.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mealapp.R
import com.example.mealapp.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealSearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavController,
    navigateToMealDetail: (String?) -> Unit
) {
    val search = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
                    .padding(1.dp)
                    .clickable {
                        navController.navigate(Screen.Meals.route)
                    },
                painter = painterResource(
                    id = R.drawable.baseline_arrow_back_24
                ),
                contentDescription = null,
                tint = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                        viewModel.mealSearch(it)
                    },
                    label = { Text(text = "Search Meal...") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Email Icon"
                        )
                    }, modifier = Modifier.clip(CircleShape)
                )
            }


        }

        if (search.isLoading) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
            }
        }
        if (search.error.isNotBlank()) {
            Text(
                text = search.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)

            )
        }


        Spacer(modifier = Modifier.height(6.dp))

        LazyColumn(contentPadding = PaddingValues(10.dp)) {
            items(search.search) {
                MealSearchItem(meal = it, onClickItem = {
                    navigateToMealDetail(it)
                })
            }
        }

    }
}