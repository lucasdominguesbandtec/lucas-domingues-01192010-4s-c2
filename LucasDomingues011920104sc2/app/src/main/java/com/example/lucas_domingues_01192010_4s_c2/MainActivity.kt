package com.example.lucas_domingues_01192010_4s_c2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun comprar(view: View) {

        val etId : EditText
        val telaErro = Intent(this, TelaErro::class.java)
        startActivity(telaErro)
    }
}