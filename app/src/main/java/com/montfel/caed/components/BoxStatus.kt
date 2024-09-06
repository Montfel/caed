package com.montfel.caed.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BoxStatus() {
    Column {
        Spacer(modifier = Modifier.height(22.dp))

        Text(text = "Status da caixa")

        Spacer(modifier = Modifier.height(19.dp))

        Card {
            LazyColumn {
                items(4) {
                    HistoricalItem()
                }
            }
        }
    }
}
