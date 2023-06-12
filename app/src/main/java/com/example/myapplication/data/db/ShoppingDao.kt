package com.example.myapplication.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.data.db.entities.Shoppingitem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Shoppingitem)

    @Delete
    suspend fun delete(item: Shoppingitem)

    @Query(value = "SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<Shoppingitem>>
}