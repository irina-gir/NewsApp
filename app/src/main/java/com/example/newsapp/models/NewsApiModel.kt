package com.example.newsapp.models

import java.io.Serializable

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
):Serializable

data class Article(
    val author: String?= null,
    val content: String?= null,
    val description: String?= null,
    val publishedAt: String?= null,
    val source: Source?= null,
    val title: String?= null,
    val url: String?= null,
    val urlToImage: String?= null
):Serializable{
    companion object{
        const val KEY_ARTICLE = "article"
    }
}

data class Source(
    val id: Any,
    val name: String
): Serializable