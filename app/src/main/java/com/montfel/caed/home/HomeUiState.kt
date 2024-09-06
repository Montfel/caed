package com.montfel.caed.home

data class HomeUiState(
    val user: String = "",
    val userSuccessful: Boolean = true,
    val password: String = "",
    val passwordSuccessful: Boolean = true,
)
