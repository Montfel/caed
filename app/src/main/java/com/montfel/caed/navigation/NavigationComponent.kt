package com.montfel.caed.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.montfel.caed.presentation.home.HomeRoute
import com.montfel.caed.presentation.login.LoginScreen
import com.montfel.caed.presentation.packagedetail.PackageDetailRoute

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login) {
        composable<Screen.Login> {
            LoginScreen(onNavigateToHome = { navController.navigate(Screen.Home) })
        }

        composable<Screen.Home> {
            HomeRoute(
                onNavigateBack = navController::popBackStack,
                onNavigateToPackageDetail = { navController.navigate(Screen.PackageDetail(it)) }
            )
        }

        composable<Screen.PackageDetail> {
            val (code) = it.toRoute<Screen.PackageDetail>()

            PackageDetailRoute(
                code = code,
                onNavigateBack = navController::popBackStack
            )
        }
    }
}