package com.example.lucas_domingues_01192010_4s_c2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import javax.security.auth.callback.Callback

class TelaErro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_erro)

        val apiCachorro = ConexaoApiCachorros.criar()

        val etId: EditText = findViewById(R.id.et_id)
        val etId2: EditText = findViewById(R.id.et_id2)
        val id = etId.text.toString().toInt()


        apiCachorro.get(id).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                val tvDescricao: TextView = findViewById(R.id.tv_descricao)
                val cachorro = response.body()
                if (cachorro != null) {
                    tvDescricao.text = "Id: ${cachorro.id} - Título: ${cachorro.raca} - Custo: ${cachorro.custoProducao}"
                } else {
                    tvDescricao.text = "Id não encontrado!!!"
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}