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

        val apiCachorro = ConexaoApiCachorros.criar()

        val etId: EditText = findViewById(R.id.et_id)
        val etId2: EditText = findViewById(R.id.et_id2)
        val id = etId.text.toString().toInt()
        val cachorro1: Cachorro ?= null
        val cachorro2: Cachorro ?= null

        apiCachorro.get(id).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                val cachorro = response.body()
                if (cachorro != null) {
                    cachorro1 = cachorro
                } else {
                    cachorro1 = null
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                cachorro1 = null
            }
        })

        apiCachorro.get(id).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                val cachorro = response.body()
                if (cachorro != null) {
                    cachorro2 = cachorro
                } else {
                    cachorro2 = null
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                cachorro2 = null
            }
        })

        if(cachorro1 == null && cachorro2 == null ) {
            val etId : EditText
            val telaErro = Intent(this, TelaErro::class.java)
            startActivity(telaErro)
        }
        else if (cachorro1 != null && cachorro2 == null) {
            val etId : EditText
            val telaEncontrei = Intent(this, CachorroEncontrado::class.java)
            startActivity(telaEncontrei)
        }

        else if (cachorro2 != null && cachorro1 == null) {
            val etId : EditText
            val telaEncontrei = Intent(this, CachorroEncontrado::class.java)
            startActivity(telaEncontrei)
        }
    }
}