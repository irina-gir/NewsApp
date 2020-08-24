package com.example.newsapp.api

import com.example.newsapp.models.NewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {
    private const val BASE_URL = "http://newsapi.org/v2/"

    private val endPoint: EndPoint by lazy {
        val client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        client.create(EndPoint::class.java)
    }

    fun getApiEndPoint(): EndPoint = endPoint
}

interface EndPoint{
    @GET("everything?q=bitcoin&from=2020-07-24&sortBy=publishedAt&apiKey=e510f97bda9a4f07858d49b0df9cd683")
    fun getNews(): Call<NewsResponse>
}