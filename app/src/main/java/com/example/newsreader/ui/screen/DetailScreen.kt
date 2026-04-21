package com.example.newsreader.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsreader.data.model.Article

@Composable
fun DetailScreen(article: Article) {

    Column(modifier = Modifier.padding(16.dp)) {

        AsyncImage(
            model = article.urlToImage,
            contentDescription = null,
            modifier = Modifier.height(250.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(article.title, style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        Text(article.description ?: "")
    }
}