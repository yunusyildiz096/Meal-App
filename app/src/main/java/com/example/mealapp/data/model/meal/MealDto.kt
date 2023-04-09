package com.example.mealapp.data.model.meal

import com.example.mealapp.domain.model.Meal

data class MealDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)

fun MealDto.toMeal(): Meal {
    return Meal(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}