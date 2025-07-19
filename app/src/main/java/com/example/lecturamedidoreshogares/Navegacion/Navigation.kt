package com.example.lecturamedidoreshogares.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lecturamedidoreshogares.LogicaUI.MedicionViewModel

@Composable
fun AppNavHost(navController: NavHostController, viewModel: MedicionViewModel) {
    NavHost(navController = navController, startDestination = Pantalla.Listado.ruta) {
        composable(Pantalla.Listado.ruta) {
            MainScreen(navController, viewModel)
       }
        composable(Pantalla.Formulario.ruta) {
           FormularioScreen(navController, viewModel)
        }
    }
}
