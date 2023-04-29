package com.example.mealapp.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapp.common.Constants
import com.example.mealapp.common.Resource
import com.example.mealapp.domain.use_case.GetMealDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailFoodViewModel @Inject constructor(
    private val getMealDetailUseCase: GetMealDetailUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel(){

    private val _state = mutableStateOf(DetailFoodState())
    val state: State<DetailFoodState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_MEAL_ID)?.let {
            getMealDetail(it)
        }
    }


    private fun getMealDetail(mealId: String) {
        getMealDetailUseCase.invoke(mealId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DetailFoodState(data = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = DetailFoodState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = DetailFoodState(error = result.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }



}











