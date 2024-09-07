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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Data
import com.montfel.caed.presentation.R

@Composable
fun Data(data: Data) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = stringResource(R.string.box_data),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(21.dp))

        DataItem(title = stringResource(R.string.code), description = data.boxCode)

        DataItem(title = stringResource(R.string.delivery_point), description = data.deliveryPoint)

        DataItem(title = stringResource(R.string.city), description = data.city)

        DataItem(title = stringResource(R.string.school), description = data.school)

        DataItem(title = stringResource(R.string.grade), description = data.grade)

        DataItem(title = stringResource(R.string.cv), description = data.cv)
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