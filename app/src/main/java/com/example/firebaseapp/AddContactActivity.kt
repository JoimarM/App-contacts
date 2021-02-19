package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddContactActivity : AppCompatActivity() {

    //Variables para crear el objeto

    lateinit var colorContact: String
    lateinit var nameContact: String
    lateinit var cityContact: String
    lateinit var estadoContact: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextColor: EditText = findViewById(R.id.editTextColor)
        val editTextCity: EditText = findViewById(R.id.editTextCity)
        val editTextStatus: EditText = findViewById(R.id.editTextStatus)
        val addButton: Button = findViewById(R.id.addButton)
        val discardButton: Button = findViewById(R.id.discardButton)

        //Funciones del activity
        setup()
        backScreen(discardButton)
        addContact(addButton, editTextName, editTextColor, editTextCity, editTextStatus)
    }

    private fun setup() {
        title = "Add Contact"
    }

    private fun backScreen(button: Button) {
        button.setOnClickListener {
            onBackPressed()
        }
    }

    private fun addContact(
        button: Button,
        name: EditText,
        color: EditText,
        city: EditText,
        estado: EditText
    ) {
        button.setOnClickListener {
            if (name.text.isNotEmpty() && color.text.isNotEmpty() && city.text.isNotEmpty() && estado.text.isNotEmpty()) {
                nameContact = name.text.toString()
                colorContact = color.text.toString()
                cityContact = city.text.toString()
                estadoContact = estado.text.toString()
                val contact = ListElement(colorContact, nameContact, cityContact, estadoContact)
                var parent = callingActivity
                intent

                Toast.makeText(applicationContext, "Contacto ${contact.name}", Toast.LENGTH_LONG)
                    .show()
                loadContacts()
            } else {
                Toast.makeText(applicationContext, "Completa todos los campos", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

    private fun loadContacts() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        onBackPressed()
    }

} //Fin clase

