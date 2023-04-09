package com.example.mealapp.navigation

sealed class Screen(val route: String){
    object Meals : Screen("categories_screen")
    object Search : Screen("meal_search_screen")
    object MealDetail : Screen("meal_detail_screen")
}
