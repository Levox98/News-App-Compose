package com.levox.newsapp.ui.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.levox.newsapp.data.models.Article
import com.levox.newsapp.ui.app.component.ArticleItem
import com.levox.newsapp.ui.app.component.SearchBar
import com.levox.newsapp.ui.viewmodel.NewsViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: NewsViewModel
) {

    val resultList = mutableListOf<Article>()

    val state by viewModel.state.collectAsState()
    val query by viewModel.searchQuery

    if (state.isLoading) {
        LoadingScreen()
    }

    if (state.searchedNews.isNotEmpty()) {
        resultList.addAll(state.searchedNews)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        SearchBar(
            text = query,
            onTextChange = { viewModel.updateQuery(it) },
            onCloseClicked = { viewModel.clearSearch() },
            onSearchClicked = { viewModel.searchNews(it) }
        )
        LazyColumn() {
            items(count = resultList.size) { index ->
                ArticleItem(
                    article = resultList[index],
                    navController = navController
                )
            }
        }
    }
}