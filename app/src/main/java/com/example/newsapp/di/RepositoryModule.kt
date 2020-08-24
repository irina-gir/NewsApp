package com.example.newsapp.di

import com.example.newsapp.api.EndPoint
import com.example.newsapp.ui.main.NewsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNewsRepository(endPoint: EndPoint): NewsRepository{
        return NewsRepository(endPoint)
    }
}