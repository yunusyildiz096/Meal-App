package com.example.mealapp.presentation.search

import com.example.mealapp.domain.model.Meal

data class MealSearchState(
    val isLoading: Boolean = false,
    val search: List<Meal> = emptyList(),
    val error: String = ""
)
