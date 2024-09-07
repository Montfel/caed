package com.montfel.caed.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Quantity
import com.montfel.caed.domain.model.QuantityType
import com.montfel.caed.presentation.R
import com.montfel.caed.presentation.theme.Blue36
import com.montfel.caed.presentation.theme.BlueAE
import com.montfel.caed.presentation.theme.GrayCC

@Composable
fun QuantityCard(quantity: Quantity) {
    val (title, typeName, color) = when (quantity.type) {
        QuantityType.RECEIVED -> {
            Triple(
                stringResource(R.string.receiving),
                stringResource(R.string.received),
                BlueAE
            )
        }

        QuantityType.RETURNED -> {
            Triple(
                stringResource(R.string.returning),
                stringResource(R.string.returned),
                Blue36
            )
        }
    }
    val totalQuantity = quantity.typeQuantity + quantity.missingQuantity

    val typeRatio = quantity.typeQuantity.toFloat().div(totalQuantity)
    val typePercentage = typeRatio.times(100)
    val missingPercentage = quantity.missingQuantity.toFloat().div(totalQuantity).times(100)

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(280.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = stringResource(R.string.quantity_title, title),
                fontWeight = FontWeight.Bold
            )

            LinearProgressIndicator(
                progress = { typeRatio },
                strokeCap = StrokeCap.Butt,
                gapSize = 10.dp,
                color = color,
                trackColor = GrayCC,
                drawStopIndicator = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .size(10.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(color)
                    )

                    Column {
                        Text(
                            text = typeName,
                            fontWeight = FontWeight.Bold
                        )

                        Text(text = stringResource(R.string.package_quantity, quantity.typeQuantity))
                    }
                }

                Text(text = "$typePercentage%")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .size(10.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(GrayCC)
                    )

                    Column {
                        Text(
                            text = stringResource(R.string.missing),
                            fontWeight = FontWeight.Bold
                        )

                        Text(text = stringResource(R.string.package_quantity, quantity.missingQuantity))
                    }
                }

                Text(text = "$missingPercentage%")
            }
        }
    }
}