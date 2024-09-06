package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.montfel.caed.presentation.theme.Gray75
import com.montfel.caed.presentation.theme.GrayF0

@Composable
fun TextFieldComponent(
    text: String,
    modifier: Modifier = Modifier,
    label: String,
    hasError: Boolean = false,
    errorMessage: String = "",
    onValueChange: (String) -> Unit,
) {
    Column {
        Text(
            text = label,
            color = Gray75
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = text,
            onValueChange = onValueChange,
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedContainerColor = GrayF0,
                unfocusedContainerColor = GrayF0,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = if (hasError) errorMessage else "",
            color = Color.Red
        )
    }
}
