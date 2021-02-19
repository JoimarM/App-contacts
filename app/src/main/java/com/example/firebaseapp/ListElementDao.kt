package com.example.firebaseapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ListElementDao {

    @Query("SELECT * FROM ListElement")
    suspend fun getAll(): List<ListElement>

    @Query("SELECT * FROM ListElement WHERE name = :name")
    suspend fun getByName(name:String): ListElement

    @Insert
    suspend fun insert(contact:ListElement)

    @Delete
    suspend fun delete(contact: ListElement)
}