package com.interview.fatsecret.local

import com.interview.fatsecret.entity.Food
import com.interview.fatsecret.entity.Receipe
import kotlinx.coroutines.flow.Flow

class DefaultLocalDataSource(val receipeDao: ReceipeDao, val foodDao: FoodDao) : LocalDataSource {
    override fun getRecipe(): Flow<List<Receipe>> {
        return receipeDao.getReceipe();
    }

    override fun getFood(): Flow<List<Food>> {
        return foodDao.getFoods();
    }

    override suspend fun insertFood(food: Food) {
        foodDao.insertFood(food)
    }

    override suspend fun insertReceipe(receipe: Receipe) {
        receipeDao.insertReceipe(receipe);
    }

}
