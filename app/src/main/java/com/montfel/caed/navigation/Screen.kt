package com.montfel.caed.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable
    data object Login : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object PackageDetail : Screen
}