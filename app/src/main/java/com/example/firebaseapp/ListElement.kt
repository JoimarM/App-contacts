package com.example.firebaseapp

import androidx.room.Entity

@Entity
data class ListElement(var color: String, var name: String, var city: String, var status: String) {

}

