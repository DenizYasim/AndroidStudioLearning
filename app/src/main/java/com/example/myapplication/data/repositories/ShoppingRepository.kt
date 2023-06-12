package com.example.myapplication.data.repositories

import com.example.myapplication.data.db.ShoppingDatabase
import com.example.myapplication.data.db.entities.Shoppingitem

class ShoppingRepository (
    private val db:ShoppingDatabase
)   {
    suspend fun upsert(item: Shoppingitem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: Shoppingitem) = db.getShoppingDao().delete(item)

    fun getALLShoppingItems()= db.getShoppingDao().getAllShoppingItems()
}