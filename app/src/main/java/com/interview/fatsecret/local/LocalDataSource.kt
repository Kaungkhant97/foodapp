package com.interview.fatsecret.local


import com.interview.fatsecret.entity.Food
import com.interview.fatsecret.entity.Receipe
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getRecipe(): Flow<List<Receipe>>;

    fun getFood(): Flow<List<Food>>;

    suspend fun insertFood(food: Food);

    suspend fun insertReceipe(receipe: Receipe);

}
