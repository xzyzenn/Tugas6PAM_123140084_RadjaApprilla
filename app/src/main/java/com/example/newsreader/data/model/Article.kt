package com.example.newsreader.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title: String,
    val description: String? = "",
    val urlToImage: String? = "",
    val content: String? = ""
)