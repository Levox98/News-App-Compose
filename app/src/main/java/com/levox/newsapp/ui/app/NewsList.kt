package com.levox.newsapp.ui.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.levox.newsapp.data.models.Article
import com.levox.newsapp.ui.viewmodel.MainViewModel

@Composable
fun NewsList(
    articles: List<Article>? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        LazyColumn() {
            items(items = articles!!) {

            }
        }
    }
}