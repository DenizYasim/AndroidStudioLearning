package com.example.myapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.db.entities.Shoppingitem

@Database(
    entities = [Shoppingitem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase?= null

        private val LOCK = Any()
        /*"operator fun invoke"executes when shoppingdatabase is called, instance ?: checks if its null(if there is a database). Synchronized stops any other
        thread from accessing it and executes the thing in brackets which checks again if null and calls createdatabase function and ".also" then calls the result of that
         */
        operator fun invoke(context: Context)= instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}