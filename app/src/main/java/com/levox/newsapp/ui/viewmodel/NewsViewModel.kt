package com.levox.newsapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levox.newsapp.data.models.Article
import com.levox.newsapp.data.network.NewsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


enum class NewsApiStatus { LOADING, ERROR, DONE }

class NewsViewModel : ViewModel() {

    private val _state = MutableStateFlow(NewsUiState())
    val state: StateFlow<NewsUiState>
        get() = _state.asStateFlow()


    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>>
        get() = _articles

    private val _selectedArticle: MutableStateFlow<Article?> = MutableStateFlow(null)
    val selectedArticle: StateFlow<Article?> = _selectedArticle.asStateFlow()

    val searchQuery: MutableState<String> = mutableStateOf("")

    fun searchNews(searchQuery: String) {

        viewModelScope.launch {
            _state.update { currentState -> currentState.copy(isLoading = true) }
            try {
                _articles.value = NewsApi.retrofitService.searchNews(searchQuery = searchQuery).articles
                _state.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        searchedNews = _articles.value ?: emptyList())
                }
            } catch (e: Exception) {
                _state.update { currentState -> currentState.copy(error = e) }
            }
        }
    }

    fun updateQuery(query: String) {
        searchQuery.value = query
    }

    fun clearSearch() {
        _state.update { currentState -> currentState.copy(searchedNews = emptyList()) }
    }
}

data class NewsUiState(
    val isLoading: Boolean = false,
    val error: Exception? = null,
    val searchedNews: List<Article> = emptyList(),
)