package com.ismadev.ismabank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SaldoCuenta : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saldo_cuenta)

        //Setup
        setup()

        //Load Data
        loadData()

    }

    private fun setup(){
        title = "Saldo en cuenta"


    }

    private fun loadData(){
        var saldoTextView = findViewById<TextView>(R.id.saldoEnCuentaTextView)

        var email = FirebaseAuth.getInstance().currentUser?.email.toString()

        db.collection("users").document(email).get().addOnSuccessListener {
            saldoTextView.setText((it.get("saldoEnCuenta") as String?) + "€")
        }
    }

}