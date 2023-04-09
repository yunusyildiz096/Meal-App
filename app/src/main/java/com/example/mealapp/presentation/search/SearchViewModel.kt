package com.example.mealapp.presentation.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapp.common.Resource
import com.example.mealapp.domain.use_case.MealSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val mealSearchUseCase: MealSearchUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MealSearchState(isLoading = false,))
    val state: State<MealSearchState> = _state

     fun mealSearch(searchText: String) {
        mealSearchUseCase.invoke(searchText).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MealSearchState(search = it.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = MealSearchState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = MealSearchState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

}