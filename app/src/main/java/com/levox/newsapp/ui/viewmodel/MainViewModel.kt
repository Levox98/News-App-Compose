package com.levox.newsapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levox.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow(NewsUiState())
    val mainState: StateFlow<NewsUiState>
        get() = _mainState.asStateFlow()

    val searchQuery: MutableState<String> = mutableStateOf("")

    fun getSearchArticles(query: String) {
        _mainState.update { currentState -> currentState.copy(isLoading = true) }
        viewModelScope.launch {
            repository.searchNews(query)
        }
    }

    data class NewsUiState(
        var isLoading: Boolean = false,
        var isDoneLoading: Boolean = false
    )
}