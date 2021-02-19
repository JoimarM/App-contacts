package com.example.firebaseapp

import android.app.Application
import androidx.room.Room

class ListElementApp : Application() {
    val room = Room.databaseBuilder(this, ContactDb::class.java, "contact").build()
}