package com.interview.fatsecret.di

import android.content.Context
import androidx.room.Room
import com.interview.fatsecret.model.DefaultLocalDataSource
import com.interview.fatsecret.model.FoodDatabase
import com.interview.fatsecret.model.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideTasksLocalDataSource(foodDatabase: FoodDatabase): LocalDataSource {
        return DefaultLocalDataSource(foodDatabase.receipeDao(),foodDatabase.foodDao());
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): FoodDatabase {
        return Room.databaseBuilder(context.applicationContext
            , FoodDatabase::class.java,"Food.db").build()
    }



}