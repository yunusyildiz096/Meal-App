package com.example.mealapp.presentation.detail

import com.example.mealapp.domain.model.Meal

data class MealDetailState constructor(
    val isLoading: Boolean = false,
    var data: Meal? = null,
    val error: String = ""
)
