package com.example.myapplication.ui.shoppinglist

import com.example.myapplication.data.db.entities.Shoppingitem

interface AddDialogListener {
    fun onAddButtonClicked(item : Shoppingitem)
}