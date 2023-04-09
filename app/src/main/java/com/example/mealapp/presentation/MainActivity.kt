package com.example.mealapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mealapp.navigation.NavGraph
import com.example.mealapp.ui.theme.MealAppTheme
import dagger.hilt.android.AndroidEntryPoint

@kotlinx.coroutines.ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealAppTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }

}

