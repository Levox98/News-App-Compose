package com.levox.newsapp.ui.app.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.levox.newsapp.R
import com.levox.newsapp.data.models.Article
import com.levox.newsapp.data.models.Source
import com.levox.newsapp.ui.theme.NewsAppComposeTheme
import com.levox.newsapp.utils.Constants

@Composable
fun ArticleItem(
    article: Article,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            backgroundColor = Color.LightGray,
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.DarkGray),
            modifier = Modifier
                .clickable {
                    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
                    navController.navigate("detail_screen")
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = article.urlToImage
                        ) ,
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
                        Text(text = "Author: ${article.author ?: "Unknown"} ")
                        Text(
                            text = "Published at: ${article.publishedAt}",
                            fontStyle = FontStyle.Italic
                        )
                        Text(
                            text = article.title!!,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = article.description!!,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleItemPreview() {
    NewsAppComposeTheme {
        ArticleItem(Article(author = "John Doe", title = "Test Article", content = "This is a " +
                "test article to test the tested functionality.",
            description = "This is a test description to test the description.",
            publishedAt = Constants.FROM, source = Source("1", "Me"), url = "",
            urlToImage = "https://media.wired.com/photos/62e9c5e1d7368105da057de3/191:100/w_1280,c_limit/BitRiver-Mining-Center-Rise-And-Fall-Of-Bitcoin-Mining-Business-1184520941.jpg"
            ), rememberNavController()
        )
    }
}