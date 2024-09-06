package com.montfel.caed.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.montfel.caed.presentation.home.HomeScreen
import com.montfel.caed.presentation.login.LoginScreen
import com.montfel.caed.presentation.packagedetail.PackageDetailScreen

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login) {
        composable<Screen.Login> {
            LoginScreen(onNavigateToHome = { navController.navigate(Screen.Home) })
        }

        composable<Screen.Home> {
            HomeScreen(
                onNavigateBack = navController::popBackStack,
                onNavigateToPackageDetail = { navController.navigate(Screen.PackageDetail) }
            )
        }

        composable<Screen.PackageDetail> {
            PackageDetailScreen(onNavigateBack = navController::popBackStack)
        }
    }
}