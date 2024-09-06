package com.montfel.caed.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import com.montfel.caed.domain.model.Status

@Composable
fun Historical(status: List<Status>) {
    Card {
        LazyColumn {
            items(status) { statusItem ->
                HistoricalItem(statusItem)
            }
        }
    }
}