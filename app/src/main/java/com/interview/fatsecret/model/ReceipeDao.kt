package com.interview.fatsecret.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.interview.fatsecret.entity.Receipe
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertReceipe(receipe: Receipe)

    @Query("SELECT * FROM Receipe")
    fun getReceipe(): Flow<List<Receipe>>
}
