package com.example.newsapp.ui.detailnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsDetailBinding
import com.example.newsapp.helpers.loadImage
import com.example.newsapp.helpers.toolbar
import com.example.newsapp.models.Article
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.activity_news_detail.view.*
import kotlinx.android.synthetic.main.activity_news_detail.view.tv_news_name

class NewsDetailActivity : AppCompatActivity() {

    var news: Article? = null
    private lateinit var binding: ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail)

        this.toolbar("News Details")
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        news = intent.getSerializableExtra(Article.KEY_ARTICLE) as Article

        init(binding.root)
    }

    private fun init(root: View) {
        root.image_news.loadImage(news!!.urlToImage!!)
        root.tv_news_name.setText(news!!.title)
        root.tv_news_author.setText("Author: " + news!!.author)
        root.tv_news_date.setText("Date Published: " + news!!.publishedAt)
        root.tv_news_content.setText(news!!.content)
        root.tv_news_description.setText(news!!.description)
        root.tv_news_url.setText(news!!.url)
    }

    //toolbar with back button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }
}