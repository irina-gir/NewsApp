package com.example.newsapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.api.ApiClient
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.helpers.toolbar
import com.example.newsapp.models.Article

class MainActivity : AppCompatActivity() {

    private lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterNews: AdapterNews
    private var newsList = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        newsViewModel = ViewModelProvider(this,
        NewsViewModelFactory(NewsRepository(ApiClient.getApiEndPoint())))
            .get(NewsViewModel::class.java)

        binding.viewModel = newsViewModel

        this.toolbar("Bitcoin News")

        init(binding.root)
        observerData()
    }

    private fun init(root: View) {
        adapterNews = AdapterNews(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            adapter = adapterNews
        }
    }

    private fun observerData() {
        newsViewModel.getNewsObserver().observe(this, Observer {
            if(it != null){
                newsList = it as ArrayList<Article>
                adapterNews.setData(newsList)
            }
        })
    }
}