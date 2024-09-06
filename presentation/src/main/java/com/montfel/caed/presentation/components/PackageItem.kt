package com.montfel.caed.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Package
import com.montfel.caed.domain.model.StatusType
import com.montfel.caed.presentation.theme.Blue36
import com.montfel.caed.presentation.theme.BlueAE
import com.montfel.caed.presentation.theme.Gray82
import com.montfel.caed.presentation.theme.GrayCC

@Composable
fun PackageItem(packageItem: Package, onClick: () -> Unit) {
    val (firstColor, secondColor) = when (packageItem.status) {
        StatusType.MISSING_PACKAGE -> GrayCC to GrayCC
        StatusType.RECEIVED_PACKAGE -> BlueAE to GrayCC
        StatusType.RETURNED_PACKAGE -> BlueAE to Blue36
        else -> GrayCC to GrayCC
    }

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
            Text(text = packageItem.code)

            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(57.dp)
                        .clip(CircleShape)
                        .background(firstColor)
                )

                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(57.dp)
                        .clip(CircleShape)
                        .background(secondColor)
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