package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable

@Composable
fun HistoricalItem() {
    Row {
        Column {
            Text(text = "24/08/23")
            Text(text = "14:32")
        }

        VerticalDivider()

        Text(text = "Coordenador recebeuu a caixa")
    }
}