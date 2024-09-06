package com.montfel.caed.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.montfel.caed.R
import com.montfel.caed.ui.theme.Blue24
import com.montfel.caed.ui.theme.BlueAE
import com.montfel.caed.ui.theme.Gray82

@Composable
fun Packages(onClick: () -> Unit) {
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
            items(3) {
                PackageItem(onClick = onClick)

                HorizontalDivider(thickness = 2.dp)
            }
        }
    }
}

@Composable
fun PackageItem(onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = 17.dp, vertical = 12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(text = "16055453593475")

            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(57.dp)
                        .clip(CircleShape)
                        .background(BlueAE)
                )

                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(57.dp)
                        .clip(CircleShape)
                        .background(Blue24)
                )
            }
        }

        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = Gray82
            )
        }
    }
}