package com.example.pertemuan14.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan14.ui.View.DetailMhsScreen
import com.example.pertemuan14.ui.View.HomeScreen
import com.example.pertemuan14.ui.View.InsertMhsView

@Composable
fun PengelolaHalaman(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiInsert.route)
                }
            )
        }

        composable(DestinasiInsert.route){
            InsertMhsView(
                onBack = {navController.popBackStack()},
                onNavigate = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }
        // **Destinasi Detail**: detail mahasiswa (mengambil parameter NIM)
        composable("detail/{nim}") { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: "" // Ambil argumen 'nim' dari rute
            DetailMhsScreen(
                nim = nim,
                navigateBack = { navController.popBackStack() }, // Balik ke layar sebelumnya
                onUpdateClick = { nim ->
                    navController.navigate("update/$nim") // Navigasi ke layar update data
                }
            )
        }
    }
}