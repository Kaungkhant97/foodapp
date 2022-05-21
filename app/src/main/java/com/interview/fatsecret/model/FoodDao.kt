package com.interview.fatsecret.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.interview.fatsecret.entity.Food
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food)

    @Query("SELECT * FROM Food")
     fun getFoods(): Flow<List<Food>>
}
