package com.example.mealapp.data.model.categories

import com.example.mealapp.domain.model.Categories

data class MealCategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)
fun MealCategoryDto.toCategories(): Categories{
    return Categories(
        idCategory = idCategory,
        strCategory = strCategory,
        strCategoryDescription = strCategoryDescription,
        strCategoryThumb = strCategoryThumb
    )
}