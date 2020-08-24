package com.example.newsapp.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.RowAdapterNewsBinding
import com.example.newsapp.models.Article
import com.example.newsapp.ui.detailnews.NewsDetailActivity

class AdapterNews(private var context:Context): RecyclerView.Adapter<AdapterNews.MyViewHolder>(){

    private var newsList = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowAdapterNewsBinding.inflate(LayoutInflater.from(context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var news = newsList[position]
        holder.bind(news)
    }

    inner class MyViewHolder(private val binding: RowAdapterNewsBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(article: Article){
            binding.article = article
            binding.executePendingBindings()
            binding.adapter = this@AdapterNews

            binding.root.setOnClickListener {
                var intent = Intent(context, NewsDetailActivity::class.java)
                intent.putExtra(Article.KEY_ARTICLE, article)
                context.startActivity(intent)
            }
        }
    }

    fun setData(list: ArrayList<Article>){
        newsList = list
        notifyDataSetChanged()
    }
}