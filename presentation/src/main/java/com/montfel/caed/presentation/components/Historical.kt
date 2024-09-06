package com.montfel.caed.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable

@Composable
fun Historical() {
    Card {
        LazyColumn {
            items(4) {
                HistoricalItem()
            }
        }
    }
}