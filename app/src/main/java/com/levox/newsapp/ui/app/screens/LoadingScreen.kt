package com.levox.newsapp.ui.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.levox.newsapp.R
import com.levox.newsapp.ui.theme.NewsAppComposeTheme

@Composable
fun LoadingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("LoadingView"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Text(
            text = stringResource(id = R.string.loading),
            fontSize = MaterialTheme.typography.h5.fontSize
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    NewsAppComposeTheme {
        LoadingScreen()
    }
}