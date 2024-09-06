package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Package
import com.montfel.caed.presentation.R

@Composable
fun Packages(packages: List<Package>, onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Text(text = "Lista de pacotes")
        }

        Spacer(modifier = Modifier.height(20.dp))

        HorizontalDivider()

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(packages) { packageItem ->
                PackageItem(
                    packageItem = packageItem,
                    onClick = onClick
                )

                HorizontalDivider(thickness = 2.dp)
            }
        }
    }
}

