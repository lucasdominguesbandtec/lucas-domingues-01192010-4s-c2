package com.example.lucas_domingues_01192010_4s_c2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CachorroEncontrado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cachorro_encontrado)

        val cachorroEncontrado = Intent(this, CachorroEncontrado::class.java)

        val cachorro1: Cachorro ?= null
        val cachorro2: Cachorro ?= null

        if(cachorro1 == null) {
            cachorroEncontrado.putExtra("racaCachorro1", getString(R.string.nao_encontrado))
        } else {
            cachorroEncontrado.putExtra("racaCachorro1", cachorro1.raca)
        }

        if(cachorro2 == null) {
            cachorroEncontrado.putExtra("racaCachorro2", getString(R.string.nao_encontrado))
        } else {
            cachorroEncontrado.putExtra("racaCachorro2", cachorro2.raca)
        }

        startActivity(cachorroEncontrado)
    }

}