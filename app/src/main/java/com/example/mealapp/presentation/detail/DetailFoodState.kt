package com.example.mealapp.presentation.detail

import com.example.mealapp.domain.model.Meal

data class DetailFoodState constructor(
    val isLoading: Boolean = false,
    var data: List<Meal?> = emptyList(),
    val error: String = ""
)
