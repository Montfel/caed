package com.montfel.caed.presentation.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnPasswordChange -> onPasswordChange(event.password)
            is LoginEvent.OnUserChange -> onUserChange(event.user)
        }
    }

    private fun onUserChange(user: String) {
        _uiState.update {
            it.copy(
                user = user,
                userSuccessful = user.isNotBlank()
            )
        }
    }

    private fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(
                password = password,
                passwordSuccessful = true
            )
        }
    }
}

