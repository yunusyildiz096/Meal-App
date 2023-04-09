package com.example.mealapp.presentation.meal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapp.common.Resource
import com.example.mealapp.domain.use_case.GetCategoriesUseCase
import com.example.mealapp.domain.use_case.GetMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealUseCase: GetMealUseCase,
): ViewModel() {
    private val _state = mutableStateOf(MealListState())
    val state: State<MealListState> = _state


    init {
        getCategories()
    }

    private fun getCategories(){
        getMealUseCase.invoke().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = MealListState(categories = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = MealListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = MealListState(error = result.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}

