package com.example.newsapp.di

import com.example.newsapp.api.EndPoint
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private const val BASE_URL = "http://newsapi.org/v2/"
    }

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideEndPoint(retrofit: Retrofit) : EndPoint{
        return retrofit.create(EndPoint::class.java)
    }
}