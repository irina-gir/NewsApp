package com.example.newsapp.ui.main

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest{

    private lateinit var newsViewModel: NewsViewModel

    @Mock
    private lateinit var newsRepository: NewsRepository

    @Before
    fun setUp(){
        println("Before the Test Cases")
        newsViewModel = NewsViewModel(newsRepository)
    }

    @Test
    fun getNews(){
        GlobalScope.launch {
            Mockito.doNothing().`when`(newsRepository.getNewsFromApi())
            Mockito.verify(newsViewModel.getNews())
            Mockito.verify(newsRepository.getNewsFromApi())
        }
    }
}