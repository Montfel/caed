package com.montfel.caed.presentation.login

data class LoginUiState(
    val user: String = "",
    val userSuccessful: Boolean = true,
    val password: String = "",
    val passwordSuccessful: Boolean = true,
)
