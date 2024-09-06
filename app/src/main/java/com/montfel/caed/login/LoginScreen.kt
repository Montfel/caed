package com.montfel.caed.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montfel.caed.R
import com.montfel.caed.components.TextFieldComponent
import com.montfel.caed.ui.theme.Yellow

@Composable
fun LoginScreen(
    onNavigateToHome: () -> Unit
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .navigationBarsPadding()
    ) {
        Image(
            painter = painterResource(R.drawable.login_background),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        Image(
            painter = painterResource(R.drawable.app_name_img),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            TextFieldComponent(
                text = uiState.user,
                label = "Usuário",
                onValueChange = {
                    viewModel.onEvent(LoginEvent.OnUserChange(it))
                },
                modifier = Modifier.fillMaxWidth()
            )

            TextFieldComponent(
                text = uiState.password,
                label = "Senha",
                onValueChange = {
                    viewModel.onEvent(LoginEvent.OnPasswordChange(it))
                },
                modifier = Modifier.fillMaxWidth()

            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNavigateToHome,
            colors = ButtonDefaults.buttonColors(
                containerColor = Yellow,
                contentColor = Color.Black
            ),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(text = "Entrar")
        }
    }
}