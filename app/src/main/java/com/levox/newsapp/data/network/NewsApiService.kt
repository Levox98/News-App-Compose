package com.levox.newsapp.data.network

import com.levox.newsapp.data.models.NewsResponse
import com.levox.newsapp.utils.Constants
import com.levox.newsapp.utils.Constants.Companion.API_KEY
import com.levox.newsapp.utils.Constants.Companion.FROM
import com.levox.newsapp.utils.Constants.Companion.TO
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(Constants.BASE_URL)
    .build()

interface NewsApi {

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String,
        @Query("from")
        fromTime: String = FROM,
        @Query("to")
        toTime: String = TO,
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<NewsResponse>
}
