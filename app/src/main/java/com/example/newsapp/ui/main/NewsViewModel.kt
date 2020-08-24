package com.example.newsapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.Article
import kotlinx.coroutines.launch

class NewsViewModel(private var newsRepository: NewsRepository): ViewModel() {
    val repoGetNews: MutableLiveData<List<Article>> by lazy {
        MutableLiveData<List<Article>>()
    }

    fun getNewsObserver() = getNews()

    fun getNews(): MutableLiveData<List<Article>>{
        viewModelScope.launch {
            val list = newsRepository.getNewsFromApi()
            repoGetNews.postValue(list)
        }
        return repoGetNews
    }
}

class NewsViewModelFactory(private var newsRepository: NewsRepository):
        ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }

}