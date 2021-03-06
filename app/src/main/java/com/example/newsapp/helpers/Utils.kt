package com.example.newsapp.helpers

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.newsapp.R
import kotlinx.android.synthetic.main.app_bar.*

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(image:String?){
    Glide.with(this)
        .load(image)
        .placeholder(R.drawable.no_image)
        .into(this)
}

fun AppCompatActivity.toolbar(title: String){
    var toolbar = this.tool_bar
    toolbar.title = title
    this.setSupportActionBar(toolbar)
}