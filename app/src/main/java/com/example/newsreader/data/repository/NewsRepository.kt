package com.example.newsreader.data.repository

import com.example.newsreader.data.model.Article
import com.example.newsreader.data.remote.ApiService

class NewsRepository {
    suspend fun getNews(): List<Article> {
        return ApiService.getNews()
    }
}