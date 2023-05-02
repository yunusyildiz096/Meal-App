package com.example.mealapp.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
        horizontalArrangement = Arrangement.SpaceBetween


    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
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
                .weight(1f),
            horizontalArrangement = Arrangement.Start

        ) {
            Text(
                text = mealName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

        }
    }
}
