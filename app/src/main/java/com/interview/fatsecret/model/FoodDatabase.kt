package com.interview.fatsecret.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.interview.fatsecret.entity.Food
import com.interview.fatsecret.entity.Receipe


@Database(entities = [Food::class, Receipe::class], version = 1, exportSchema = false)
abstract class FoodDatabase:RoomDatabase(){

    abstract fun foodDao(): FoodDao
    abstract fun receipeDao(): ReceipeDao

}
