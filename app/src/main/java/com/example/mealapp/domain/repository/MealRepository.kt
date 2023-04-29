package com.example.mealapp.domain.repository

import com.example.mealapp.data.model.categories.MealCategoriesResponse
import com.example.mealapp.data.model.detail.MealDetailDto
import com.example.mealapp.data.model.detail.MealDetailResponse
import com.example.mealapp.data.model.meal.MealDto
import com.example.mealapp.data.model.meal.MealResponse

interface MealRepository {

    suspend fun searchMeal(queryValue: String): MealResponse
    suspend fun getMealDetail(mealId: String): MealResponse
    suspend fun getMeal(): MealResponse
    suspend fun getCategories(): MealCategoriesResponse

}