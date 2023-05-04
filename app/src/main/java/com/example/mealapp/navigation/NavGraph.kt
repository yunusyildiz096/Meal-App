package com.example.mealapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mealapp.presentation.detail.MealDetailScreen
import com.example.mealapp.presentation.meal.MealScreen
import com.example.mealapp.presentation.search.MealSearchScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun NavGraph(navController: NavHostController) {


    NavHost(
        navController = navController,
    startDestination = Screen.Search.route){


        composable(route = Screen.Meals.route){
            MealScreen(navController = navController, navigateToMealDetail = {
                navController.navigate("${Screen.MealDetail.route}/$it")
            })
        }

        composable(route = Screen.Search.route){
            MealSearchScreen(navigateToMealDetail = {
                navController.navigate("${Screen.MealDetail.route}/$it")
            }, navController = navController)
        }

        composable(route = "${Screen.MealDetail.route}/{mealId}"){
            MealDetailScreen(navController = navController)
        }
    }

}