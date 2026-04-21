package com.example.newsreader.data.remote

import com.example.newsreader.data.model.Article
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

object ApiService {

    private const val BASE_URL = "https://newsapi.org/v2/"
    private const val API_KEY = "2ff0ddb9f6d0439ebcfe959e0eeac757"

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getNews(): List<Article> {
        val response: NewsResponse = client.get("${BASE_URL}top-headlines") {
            url {
                parameters.append("country", "us")
                parameters.append("apiKey", API_KEY)
            }
        }.body()

        return response.articles
    }
}

@Serializable
data class NewsResponse(
    val articles: List<Article>
)