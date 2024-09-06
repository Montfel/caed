package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import com.montfel.caed.domain.model.Status

@Composable
fun HistoricalItem(status: Status) {
    Row {
        Column {
            Text(text = status.time)
            Text(text = status.time)
        }

        VerticalDivider()

        Text(text = status.description)
    }
}