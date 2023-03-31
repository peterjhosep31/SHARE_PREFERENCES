package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    var textUser: EditText?=null
    var textPasswor:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()

    }



    private fun iniciarComponentes() {

        var botonGuardar: Button =findViewById(R.id.btnGuardar)
        botonGuardar.setOnClickListener { guardarDatos() }

        var botonCargar:Button=findViewById(R.id.btnCargar)
        botonCargar.setOnClickListener { activarVista() }

        textUser=findViewById(R.id.campoUser)
        textPasswor=findViewById(R.id.campoPass)

    }

    private fun activarVista() {
        val view = Intent(this, TwoView::class.java)
        startActivity(view)
    }

    private fun guardarDatos() {

        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var user= textUser?.text.toString()
        var pass= textPasswor?.text.toString()

        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user",user)
        editor.putString("pass",pass)

        editor.commit()

        Toast.makeText(this,"Se han registrado los datos", Toast.LENGTH_SHORT).show()
    }

}