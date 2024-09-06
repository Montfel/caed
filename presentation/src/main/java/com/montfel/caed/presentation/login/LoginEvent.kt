package com.montfel.caed.presentation.login

sealed interface LoginEvent {
    data class OnUserChange(val user: String) : LoginEvent
    data class OnPasswordChange(val password: String) : LoginEvent
}