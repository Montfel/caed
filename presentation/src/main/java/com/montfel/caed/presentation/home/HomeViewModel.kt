package com.montfel.caed.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.caed.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getHome()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            else -> {}
        }
    }

    private fun getHome() {
        viewModelScope.launch {
            val box = homeRepository.getHome()

            _uiState.update {
                it.copy(box = box)
            }
        }
    }
}

