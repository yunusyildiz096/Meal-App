package com.example.mealapp.domain.use_case

import com.example.mealapp.common.Resource
import com.example.mealapp.data.model.categories.toCategories
import com.example.mealapp.domain.model.Categories
import com.example.mealapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(

    private val mealRepository: MealRepository
) {
    operator fun invoke(): Flow<Resource<List<Categories>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = mealRepository.getCategories().categories.map { it.toCategories() }
            emit(Resource.Success(categories))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}