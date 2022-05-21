package com.interview.fatsecret.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.interview.fatsecret.view.FoodListViewObject

@Entity(tableName = "Receipe")
data class Receipe constructor(
    @PrimaryKey(autoGenerate = true) var ID: Long = 0L,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "quantity") var quantity: Int,
    @ColumnInfo(name = "cookingTime") var cookingTime: Int,
    @ColumnInfo(name = "time") val time:Long = System.currentTimeMillis()
) {

    fun toFoodListViewObject(): FoodListViewObject =
        FoodListViewObject(this.ID.toString(), this.name, this.quantity.toString(), this.cookingTime.toString(),this.time)
}
