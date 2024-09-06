package com.montfel.caed.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Data() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Text(text = "Dados da caixa")

        Spacer(modifier = Modifier.height(21.dp))

        Row {
            Text("CÓDIGO")

            Text("16055453593475")
        }

        Row {
            Text("PONTO DE ENTREGA")

            Text("16055453593475")
        }

        Row {
            Text("MUNICÍPIO")

            Text("16055453593475")
        }

        Row {
            Text("ESCOLA")

            Text("16055453593475")
        }

        Row {
            Text("ANO ESCOLAR/ETAPA")

            Text("16055453593475")
        }

        Row {
            Text("COMPONENTE CURRICULAR")

            Text("16055453593475")
        }
    }
}