package com.levox.newsapp.data

import com.levox.newsapp.data.models.NewsResponse
import com.levox.newsapp.domain.repository.NewsRepository

object NewsRepositoryImpl : NewsRepository {
    override suspend fun searchNews(query: String): List<NewsResponse> {
        TODO("Not yet implemented")
    }
}