package com.ismadev.ismabank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setup
        val bundle = intent.extras
        val email = bundle?.getString("email")

        setup()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.principal_menu,menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cerrarSesionMenu -> cerrarSesion()
            R.id.configMenu -> configMenuActivityLaunch()
        }
        return true

    }

    private fun setup(){

        title = "Inicio"

    }

    private fun configMenuActivityLaunch(){
        val configIntent = Intent(this, ConfigUser::class.java).apply {
        }

        startActivity(configIntent)
    }

    private fun cerrarSesion(){
        FirebaseAuth.getInstance().signOut()
        onBackPressed()
    }

}