package com.levox.newsapp

sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
    object Article : Screen("article_screen")
}
