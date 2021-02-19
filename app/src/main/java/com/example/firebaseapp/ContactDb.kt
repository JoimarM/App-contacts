package com.example.firebaseapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ListElement::class],
    version = 1
)
abstract class ContactDb: RoomDatabase() {

    abstract fun listElementDao(): ListElementDao
}