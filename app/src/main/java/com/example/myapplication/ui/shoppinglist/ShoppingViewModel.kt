package com.example.myapplication.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.db.entities.Shoppingitem
import com.example.myapplication.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    fun upsert(item: Shoppingitem)= CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: Shoppingitem)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getALLShoppingItems()= repository.getALLShoppingItems()
}