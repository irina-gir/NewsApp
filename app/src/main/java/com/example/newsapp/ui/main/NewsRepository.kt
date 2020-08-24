package com.example.newsapp.ui.main

import android.util.Log
import com.example.newsapp.api.EndPoint
import com.example.newsapp.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class NewsRepository(private var endPoint: EndPoint) {

    open suspend fun getNewsFromApi(): List<Article>? {
        return withContext(Dispatchers.IO) {
            val call = endPoint.getNews()
            val response = call.execute()
            if (response != null && response.code() in 200..399){
                response.body()!!.articles
            }else
                null
        }
    }
}