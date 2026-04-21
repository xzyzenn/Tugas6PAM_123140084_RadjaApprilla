package com.example.newsreader.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsreader.data.model.Article
import com.example.newsreader.data.repository.NewsRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.*

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    var articles by mutableStateOf<List<Article>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            isLoading = true
            try {
                articles = repository.getNews()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            isLoading = false
        }
    }
}