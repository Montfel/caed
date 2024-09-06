package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Status

@Composable
fun PackageStatus(status: List<Status>) {
    Column {
        Spacer(modifier = Modifier.height(22.dp))

        Text(text = "Status do pacote")

        Spacer(modifier = Modifier.height(19.dp))

        Timeline(status)
    }
}
