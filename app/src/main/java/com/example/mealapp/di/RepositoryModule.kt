package com.example.mealapp.di

import com.example.mealapp.data.remote.MealService
import com.example.mealapp.data.repository.MealRepositoryImpl
import com.example.mealapp.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMealRepository(mealService: MealService) =
        MealRepositoryImpl(mealService) as MealRepository
}