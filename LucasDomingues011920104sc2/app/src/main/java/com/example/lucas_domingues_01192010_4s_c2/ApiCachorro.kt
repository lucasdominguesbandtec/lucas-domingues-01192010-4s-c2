package com.example.lucas_domingues_01192010_4s_c2

interface piCachorro {
    @GET("cachorros")
    fun get(): Call<List<Cachorro>>

    @GET("cachorros/{id}")
    fun get(@Path("id") id:Int): Call<Cachorro>

}