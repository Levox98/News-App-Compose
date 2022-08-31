package com.levox.newsapp.utils

import com.google.gson.internal.bind.util.ISO8601Utils.format
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class Constants {
    companion object {
        val BASE_URL = "https://newsapi.org"
        val API_KEY = "d44b65951a5642dd9d9b699384536d16"
        val FROM = "${ LocalDate.now() }"
        val TO = "${ LocalDate.now().minusDays(30)}"
    }
}