package com.example.mealapp.data.remote

import com.example.mealapp.data.model.categories.MealCategoriesResponse
import com.example.mealapp.data.model.detail.MealDetailDto
import com.example.mealapp.data.model.detail.MealDetailResponse
import com.example.mealapp.data.model.meal.MealDto
import com.example.mealapp.data.model.meal.MealResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MealService {

    @GET("search.php")
    suspend fun searchMeal(
        @Query("s") queryValue: String
    ): MealResponse

    //www.themealdb.com/api/json/v1/1/lookup.php?i=52772
    @GET("lookup.php?")
    suspend fun getMealDetail( @Query("i") id: String): MealResponse


    @GET("filter.php?i=beef")
    suspend fun getMeal(): MealResponse

    @GET("categories.php")
    suspend fun getCategories(): MealCategoriesResponse



}