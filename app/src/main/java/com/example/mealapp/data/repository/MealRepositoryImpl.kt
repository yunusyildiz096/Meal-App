package com.example.mealapp.data.repository

import com.example.mealapp.data.model.categories.MealCategoriesResponse
import com.example.mealapp.data.model.detail.MealDetailDto
import com.example.mealapp.data.model.detail.MealDetailResponse
import com.example.mealapp.data.model.meal.MealDto
import com.example.mealapp.data.model.meal.MealResponse
import com.example.mealapp.data.remote.MealService
import com.example.mealapp.domain.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImpl(private val api: MealService): MealRepository {


    override suspend fun searchMeal(queryValue: String): MealResponse {
        return api.searchMeal(queryValue)
    }

    override suspend fun getMealDetail(mealId: String): MealDto {
        return api.getMealDetail(mealId)
    }

    override suspend fun getMeal(): MealResponse {
        return api.getMeal()
    }

    override suspend fun getCategories(): MealCategoriesResponse {
        return api.getCategories()
    }


}