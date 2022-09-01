package com.levox.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.levox.newsapp.data.models.Article
import com.levox.newsapp.ui.app.screens.DetailScreen
import com.levox.newsapp.ui.app.screens.MainScreen
import com.levox.newsapp.ui.app.screens.NewsApp
import com.levox.newsapp.ui.theme.NewsAppComposeTheme
import com.levox.newsapp.ui.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppComposeTheme {
                navController = rememberNavController()

                NewsApp(navController = navController, viewModel = viewModel)
            }
        }
    }
}
