package com.example.lecturamedidoreshogares

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.lecturamedidoreshogares.LogicaUI.MedicionViewModel
import com.example.lecturamedidoreshogares.Navegacion.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           val navController = rememberNavController()
           val viewModel: MedicionViewModel = viewModel()
            AppNavHost(navController = navController, viewModel = viewModel)
        }
    }
}
