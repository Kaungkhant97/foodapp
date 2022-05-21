package com.interview.fatsecret.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.fatsecret.entity.Food
import com.interview.fatsecret.entity.Receipe
import com.interview.fatsecret.local.LocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FoodAddViewModel  @Inject constructor(private val localDataSource : LocalDataSource) : ViewModel()  {

    fun insertReceipe(name:String,cookingTime:Int,quantity:Int){
        viewModelScope.launch {
          withContext(Dispatchers.IO){
              localDataSource.insertReceipe(Receipe(name =name, quantity = quantity, cookingTime = cookingTime ))
          }

        }
    }

    fun insertFood(name:String,description:String,amount:Int){
    viewModelScope.launch {
        localDataSource.insertFood(Food(name =name, description = description, quantity = amount ))
    }

    }

}