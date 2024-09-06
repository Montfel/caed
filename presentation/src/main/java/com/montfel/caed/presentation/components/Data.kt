package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Data

@Composable
fun Data(data: Data) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Text(text = "Dados da caixa")

        Spacer(modifier = Modifier.height(21.dp))

        DataItem(title = "CÓDIGO", description = data.boxCode)

        DataItem(title = "PONTO DE ENTREGA", description = data.deliveryPoint)

        DataItem(title = "MUNICÍPIO", description = data.city)

        DataItem(title = "ESCOLA", description = data.school)

        DataItem(title = "ANO ESCOLAR/ETAPA", description = data.grade)

        DataItem(title = "COMPONENTE CURRICULAR", description = data.cv)
    }
}

@Composable
fun DataItem(title: String, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = description,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
    }

    HorizontalDivider()
}