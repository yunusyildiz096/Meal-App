package com.example.mealapp.domain.use_case

import com.example.mealapp.common.Resource
import com.example.mealapp.data.model.detail.toMealDetail
import com.example.mealapp.data.model.meal.toMeal
import com.example.mealapp.domain.model.Detail
import com.example.mealapp.domain.model.Meal
import com.example.mealapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealDetailUseCase @Inject constructor(
    private val mealRepository: MealRepository
){

    operator fun invoke(mealId: String): Flow<Resource<Meal>> = flow {

        try {
            emit(Resource.Loading())
            mealRepository.getMealDetail(mealId).toMeal().let {
                emit(Resource.Success(it))
            }
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }

    }




}