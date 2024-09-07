package com.montfel.caed.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.montfel.caed.presentation.R
import com.montfel.caed.presentation.theme.BlueCD
import com.montfel.caed.presentation.theme.Gray82
import com.montfel.caed.presentation.theme.Gray33

@Composable
fun NavigationBarCustom() {
    val navigationBarItems =
        listOf(
            NavigationItem(
                icon = Icons.Default.Home,
                name = stringResource(R.string.home),
                selected = true
            ),
            NavigationItem(
                icon = Icons.Default.Settings,
                name = stringResource(R.string.options)
            ),
            NavigationItem(
                icon = Icons.Default.Info,
                name = stringResource(R.string.tutorials)
            ),
        )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp,
        modifier = Modifier.height(80.dp)
    ) {
        navigationBarItems.forEach { navigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Gray33,
                    unselectedIconColor = Gray82,
                    selectedTextColor = Gray33,
                    unselectedTextColor = Gray82,
                    indicatorColor = BlueCD,
                ),
                selected = navigationItem.selected,
                onClick = {},
                label = {
                    Text(text = navigationItem.name)
                },
                icon = {
                    Icon(
                        imageVector = navigationItem.icon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

data class NavigationItem(
    val icon: ImageVector,
    val name: String,
    val selected: Boolean = false
)
