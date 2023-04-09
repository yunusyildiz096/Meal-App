package com.example.mealapp.presentation.meal

import com.example.mealapp.domain.model.Meal

data class MealListState(
    val isLoading: Boolean = false,
    val categories: List<Meal> = emptyList(),
    val error: String = ""
)
