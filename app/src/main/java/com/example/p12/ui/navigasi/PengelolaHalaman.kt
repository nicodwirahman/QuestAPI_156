package com.example.p12.ui.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p12.ui.View.DestinasiEntry
import com.example.p12.ui.View.DestinasiHome
import com.example.p12.ui.View.DetailScreen
import com.example.p12.ui.View.EntryMhsScreen
import com.example.p12.ui.View.HomeScreen
import com.example.p12.ui.View.UpdateScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController, startDestination = DestinasiHome.route, modifier = Modifier,
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route) {
                    popUpTo(DestinasiHome.route) {
                        inclusive = true

                    }
                }
            })

        }
        composable("detail/{nim}") { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            DetailScreen(
                nim = nim,
                navigateBack = { navController.popBackStack() },
                onUpdateClick = { nim ->
                    navController.navigate("update/$nim")
                }
            )
        }
        composable("update/{nim}") { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            UpdateScreen(
                nim = nim,
                navigateBack = { navController.popBackStack() }
            )
    }
}
}


