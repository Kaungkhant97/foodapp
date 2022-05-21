package com.interview.fatsecret.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.interview.fatsecret.entity.Food
import com.interview.fatsecret.local.LocalDataSource
import com.interview.fatsecret.view.FoodListViewObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val localDataSource: LocalDataSource) :
    ViewModel() {


    private val _allFood: Flow<List<FoodListViewObject>> =
        localDataSource.getFood().map { it.map { it.toFoodListViewObject() } }
    private val _allReceipe: Flow<List<FoodListViewObject>> =
        localDataSource.getRecipe().map { it.map { it.toFoodListViewObject() } }


    var _allFoodViewObject: LiveData<List<FoodListViewObject>> =_allFood.zip(_allReceipe,{foods,receips -> foods.toMutableList().apply { addAll(receips)
    sortBy { it.time }}}).asLiveData()




}