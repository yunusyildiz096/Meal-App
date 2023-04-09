package com.example.mealapp.data.model.detail

import com.example.mealapp.domain.model.Detail

data class MealDetailDto(
    val idMeal: String? = null,
    val strArea: String?,
    val strCategory: String?,
    val strInstructions: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strYoutube: String?,
    val strTags: String?,
)

fun MealDetailDto.toMealDetail(): Detail{
    return Detail(
        idMeal = idMeal,
        strArea = strArea,
        strCategory = strCategory,
        strInstructions = strInstructions,
        strIngredient1 = strIngredient1,
        strIngredient2 = strIngredient2,
        strIngredient3 = strIngredient3,
        strIngredient4 = strIngredient4,
        strIngredient5 = strIngredient5,
        strMeal = strMeal,
        strMealThumb = strMealThumb,
        strYoutube = strYoutube,
        strTags = strTags
    )
}