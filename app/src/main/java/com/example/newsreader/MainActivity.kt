package com.example.newsreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.newsreader.ui.screen.*
import com.example.newsreader.ui.viewmodel.NewsViewModel
import com.example.newsreader.data.model.Article

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel = remember { NewsViewModel() }
            var selectedArticle by remember { mutableStateOf<Article?>(null) }

            if (selectedArticle == null) {
                HomeScreen(viewModel) {
                    selectedArticle = it
                }
            } else {
                DetailScreen(selectedArticle!!)
            }
        }
    }
}