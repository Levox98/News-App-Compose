package com.levox.newsapp.ui.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.levox.newsapp.Screen
import com.levox.newsapp.ui.theme.NewsAppComposeTheme

@Composable
fun ArticleScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Article",
            fontSize = 50.sp,
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleScreenPreview() {
    NewsAppComposeTheme {
        ArticleScreen(navController = rememberNavController())
    }
}