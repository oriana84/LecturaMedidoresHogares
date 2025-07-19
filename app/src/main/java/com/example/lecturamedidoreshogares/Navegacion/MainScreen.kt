package com.example.lecturamedidoreshogares.Navegacion
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lecturamedidoreshogares.LogicaUI.MedicionViewModel
import com.example.lecturamedidoreshogares.R
import com.example.lecturamedidoreshogares.modelo.TipoGasto

@Composable
fun MainScreen(navController: NavController, viewModel: MedicionViewModel) {
    val lista by viewModel.lista
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Pantalla.Formulario.ruta)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 35.dp)
        ) {
            items(lista) { medicion ->
                Column(){
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(
                                id = when (medicion.tipo) {
                                    TipoGasto.AGUA -> R.drawable.agua
                                    TipoGasto.LUZ -> R.drawable.luz
                                    TipoGasto.GAS -> R.drawable.gas
                                }
                            ),
                            contentDescription = medicion.tipo.name
                        )
                            Text(medicion.tipo.name)
                            Text(medicion.valor.toString())
                            Text(medicion.fecha)
                    }
                        Spacer( modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    LaunchedEffect(Unit) {
            viewModel.cargarMediciones()
    }
}





