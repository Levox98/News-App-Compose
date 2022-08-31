package com.levox.newsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.levox.newsapp.ui.app.ArticleScreen
import com.levox.newsapp.ui.app.MainScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(
            route = Screen.Main.route
        ) {
            MainScreen(navController)
        }
        composable(
            route = Screen.Article.route
        ) {
            ArticleScreen(navController)
        }
    }
}