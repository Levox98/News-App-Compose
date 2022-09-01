package com.levox.newsapp

import com.levox.newsapp.data.models.Article


sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
    object ArticleScreen : Screen("article_screen/{article}") {
        fun passArticle(article: Article): String {
            return "article_screen/${article}"
        }
    }
}
