package com.example.firebaseapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.IntentCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

enum class ProviderType {
    BASIC
}



class HomeActivity : AppCompatActivity() {
    var elements = ArrayList<ListElement>()
    lateinit var recyclerView: RecyclerView
    lateinit var  adapter:ListAdapter
    val app = applicationContext as ListElementApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lifecycleScope.launch {
            val contacts = app.room.listElementDao().getAll()
        }

        //Setup adaptador vista lista de contactos
        recyclerView = findViewById(R.id.listRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

         adapter = ListAdapter(elements)
        recyclerView.adapter = adapter

        /*               //Setup
               val bundle:Bundle? = intent.extras
               val email:String? = bundle?.getString("email")
               val provider:String? = bundle?.getString("provider")
               setup(email?:"", provider?:"")
           }

           private fun setup (email:String, provider:String){
               title = "Inicio"
               var emailTextView: TextView = findViewById(R.id.emailTextView)
               var providerView: TextView = findViewById(R.id.ProviderTextView)
               emailTextView.text = email
               providerView.text = provider
               val buttonLogOut: Button = findViewById(R.id.buttonLogOut)
               buttonLogOut.setOnClickListener {
                   FirebaseAuth.getInstance().signOut()
                   onBackPressed()
               }*/

        //Setup FAB add contact
        showAddContactScreen(this)
        for (element in elements){
            print(element.name)
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    fun addElement(element: ListElement){
        elements.add(element)
        adapter.notifyDataSetChanged()
    }


    //Funcion mostrar add contact
    private fun showAddContactScreen(context: Context) {
        val addContactFab: FloatingActionButton = findViewById(R.id.addContactFab)
        addContactFab.setOnClickListener {
            var intentAdd = Intent(this, AddContactActivity::class.java)
            startActivity(intentAdd)
        }

    }
}