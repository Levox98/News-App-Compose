package com.levox.newsapp.ui.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.levox.newsapp.ui.app.NewsList
import com.levox.newsapp.ui.app.SearchBar
import com.levox.newsapp.ui.theme.NewsAppComposeTheme
import com.levox.newsapp.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        SearchBar(
            text = "",
            onTextChange = {},
            onCloseClicked = {},
            onSearchClicked = {}
        )
        NewsList()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    NewsAppComposeTheme {
        MainScreen(navController = rememberNavController(), null)
    }
}