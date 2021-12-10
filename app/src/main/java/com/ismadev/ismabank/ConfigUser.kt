package com.ismadev.ismabank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ConfigUser : AppCompatActivity() {
    lateinit var usuario : User
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config_user)
        val bundle = intent.extras
        var email = FirebaseAuth.getInstance().currentUser?.email.toString()
        var saveUserButton = findViewById<Button>(R.id.saveUserButton)

        var username = findViewById<EditText>(R.id.username)



        //Setup
        setup()



        saveUserButton.setOnClickListener {
            saveUser(email.toString(),username.text.toString())

        }



    }

    private fun setup(){

    }

    private fun saveUser(email: String, name: String){
        db.collection("users").document(email).set(
            hashMapOf("username" to name)
        )
    }

    /*private fun saveUser(user : User){
        db.collection("users").document(user.email).set(
            hashMapOf("username" to user.name)
        )
    }*/

}