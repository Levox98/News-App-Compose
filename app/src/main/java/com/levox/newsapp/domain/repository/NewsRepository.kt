package com.levox.newsapp.domain.repository

import com.levox.newsapp.data.models.NewsResponse

interface NewsRepository {

    suspend fun searchNews(query: String): List<NewsResponse>
}