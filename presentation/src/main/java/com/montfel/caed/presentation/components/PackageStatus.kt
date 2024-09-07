package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Status
import com.montfel.caed.presentation.R

@Composable
fun PackageStatus(status: List<Status>) {
    Column {
        Spacer(modifier = Modifier.height(22.dp))

        Text(
            text = stringResource(R.string.package_status),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(19.dp))

        Timeline(status)
    }
}
