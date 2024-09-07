package com.montfel.caed.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.caed.domain.repository.HomeRepository
import com.montfel.caed.domain.util.ResultType
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

    private fun getHome() {
        viewModelScope.launch {
            when (val result = homeRepository.getHome()) {
                is ResultType.Failure -> {
                    _uiState.update {
                        it.copy(stateOfUi = HomeStateOfUi.Error)
                    }
                }
                is ResultType.Success -> {
                    _uiState.update {
                        it.copy(
                            box = result.data,
                            stateOfUi = HomeStateOfUi.Success
                        )
                    }
                }
            }
        }
    }
}

