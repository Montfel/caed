package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PackageTypeCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(280.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "Recebimento dos pacotes")

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Recebidos")
                    Text(text = "1560 pacotes")
                }

                Text(text = "75%")
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Faltantes")
                    Text(text = "440 pacotes")
                }

                Text(text = "25%")
            }
        }
    }
}