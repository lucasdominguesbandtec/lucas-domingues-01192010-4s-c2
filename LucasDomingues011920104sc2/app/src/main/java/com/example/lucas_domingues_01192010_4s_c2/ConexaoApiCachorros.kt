package com.example.lucas_domingues_01192010_4s_c2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoApiCachorros {
    fun criar(): ApiCachorro{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/cachorros\n")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiCachorros::class.java)

        return api
    }
}