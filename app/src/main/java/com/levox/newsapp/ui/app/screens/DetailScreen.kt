package com.levox.newsapp.ui.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.levox.newsapp.data.models.Article
import com.levox.newsapp.data.models.Source
import com.levox.newsapp.ui.theme.NewsAppComposeTheme
import com.levox.newsapp.utils.Constants

@Composable
fun DetailScreen(
    article: Article? = null
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = article?.urlToImage
                    ),
                    contentDescription = "Article image",
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(start = 4.dp)
                ) {
                    Text(text = "Author: ${article?.author}")
                    Text(
                        text = "Published at: ${article?.publishedAt}",
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = article?.title ?: "",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = article?.content ?: "No content",
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticleScreenPreview() {
    NewsAppComposeTheme {
        DetailScreen(
            Article(
                author = "John Doe", title = "Test Article", content = "This is a " +
                        "test article to test the tested functionality.",
                description = "This is a test description to test the description.",
                publishedAt = Constants.FROM, source = Source("1", "Me"), url = "",
                urlToImage = "https://media.wired.com/photos/62e9c5e1d7368105da057de3/191:100/w_1280,c_limit/BitRiver-Mining-Center-Rise-And-Fall-Of-Bitcoin-Mining-Business-1184520941.jpg"
            )
        )
    }
}