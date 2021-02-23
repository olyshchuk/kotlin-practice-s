package com.msl.kotlin_practice_s.network

import com.msl.kotlin_practice_s.model.RickListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("/character")
    fun getData(@Query("page") page: Int): Call<RickListModel>
}