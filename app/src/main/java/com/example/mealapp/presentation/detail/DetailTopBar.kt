package com.example.mealapp.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mealapp.R
import com.example.mealapp.navigation.Screen

@Composable
fun DetailTopBar(
    mealName: String,
    navController: NavController
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center

    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
                .padding(0.dp)
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
                .padding(10.dp)
        ) {
            Text(
                text = mealName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

        }

        FavoriteFood()

    }
}

@Composable
fun FavoriteFood() {
    var isFavorite by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier
                .size(24.dp)
                .padding(0.dp)
                .clickable {
                    isFavorite = !isFavorite
                },
            painter = painterResource(
                id = if (isFavorite) R.drawable.baseline_bookmark_24 else R.drawable.baseline_bookmark_border_24
            ),
            contentDescription = null,
            tint = if (isFavorite) Color.Red else Color.Black
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ShowTopBar(){

    val navController = rememberNavController()
    DetailTopBar(mealName = "wadawda", navController = navController)
}