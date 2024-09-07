package com.montfel.caed.presentation.home

import com.montfel.caed.domain.model.Box

data class HomeUiState(
    val box: Box? = null,
    val stateOfUi: HomeStateOfUi = HomeStateOfUi.Loading
)

sealed interface HomeStateOfUi {
    data object Loading : HomeStateOfUi
    data object Error : HomeStateOfUi
    data object Success : HomeStateOfUi
}