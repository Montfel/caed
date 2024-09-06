package com.montfel.caed.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.montfel.caed.domain.model.Status
import com.montfel.caed.domain.model.StatusType
import com.montfel.caed.presentation.theme.Blue36
import com.montfel.caed.presentation.theme.BlueAE
import com.montfel.caed.presentation.theme.GrayCC
import com.montfel.caed.presentation.theme.Green0C
import com.montfel.caed.presentation.theme.GreenA6

@Composable
fun TimelineItem(status: Status) {
    val color = when (status.status) {
        StatusType.MISSING_PACKAGE -> GrayCC
        StatusType.RECEIVED_PACKAGE, StatusType.OPENED_BOX -> BlueAE
        StatusType.RETURNED_PACKAGE, StatusType.READ_BOX -> Blue36
        StatusType.RECEIVED_BOX -> GreenA6
        StatusType.RETURNED_BOX -> Green0C
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = status.date)

                Text(text = status.time)
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.weight(0.5f)
        ) {
            VerticalDivider(color = GrayCC)

            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }

        Text(
            text = status.description,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(2f)
        )
    }
}