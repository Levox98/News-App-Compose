package com.levox.newsapp.ui.app.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.levox.newsapp.data.models.Article
import com.levox.newsapp.ui.viewmodel.NewsViewModel

@Composable
fun NewsApp(navController: NavHostController, viewModel: NewsViewModel) {
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable("detail_screen") {
            val article =
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")

            article?.let {
                DetailScreen(article = it)
            }
        }
    }
}