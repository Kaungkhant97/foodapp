package com.interview.fatsecret.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.interview.fatsecret.view.FoodListViewObject

@Entity(tableName = "Food")
data class Food (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var ID:Long = 0L ,
                            @ColumnInfo(name = "name") var name:String,
                            @ColumnInfo(name = "quantity") var quantity:Int,
                            @ColumnInfo(name = "description") var description:String,
                            @ColumnInfo(name = "time") val time:Long = System.currentTimeMillis()) {
    fun toFoodListViewObject(): FoodListViewObject = FoodListViewObject(this.ID.toString(),this.name,this.quantity.toString(),this.description,this.time)
}