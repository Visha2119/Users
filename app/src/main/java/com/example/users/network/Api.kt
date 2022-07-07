package com.example.users.network

import com.example.users.model.RepositoriesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api")
    fun getResults(@Query("results")query:String) : Call<RepositoriesList>
}