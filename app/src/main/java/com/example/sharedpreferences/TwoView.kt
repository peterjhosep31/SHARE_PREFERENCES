package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TwoView : AppCompatActivity() {
    var user: TextView?= null
    var password: TextView?= null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_view)
        val btnButton: Button? = findViewById(R.id.mostrar)
        btnButton?.setOnClickListener { cargarDatos() }

        user = findViewById(R.id.shareUser)
        password = findViewById(R.id.sharePassword)

    }
    private fun cargarDatos() {
        var preferences: SharedPreferences =getSharedPreferences("credenciales", MODE_PRIVATE)

        var dataUser: String? =preferences.getString("user","No existe la información")
        var dataPassword: String? =preferences.getString("pass","No existe la información")

        user?.text=dataUser
        password?.text=dataPassword

    }
}