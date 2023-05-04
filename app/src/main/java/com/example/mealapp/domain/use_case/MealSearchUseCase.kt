package com.example.mealapp.domain.use_case

import com.example.mealapp.common.Resource
import com.example.mealapp.data.model.meal.toMeal
import com.example.mealapp.domain.model.Meal
import com.example.mealapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MealSearchUseCase @Inject constructor(
    private val mealRepository: MealRepository
){
    operator fun invoke(queryValue: String): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading())
            val search = mealRepository.searchMeal(queryValue = queryValue).meals.map { it.toMeal() }
            emit(Resource.Success(data = search))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }

    }
}