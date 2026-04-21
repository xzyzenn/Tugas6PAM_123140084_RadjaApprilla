package com.example.newsreader.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsreader.data.model.Article
import com.example.newsreader.ui.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    viewModel: NewsViewModel,
    onClick: (Article) -> Unit
) {

    val articles = viewModel.articles

    LazyColumn {
        items(articles) { article ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onClick(article) }
            ) {
                Column(modifier = Modifier.padding(8.dp)) {

                    AsyncImage(
                        model = article.urlToImage,
                        contentDescription = null,
                        modifier = Modifier.height(200.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(article.title, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}