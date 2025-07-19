package com.example.lecturamedidoreshogares.Navegacion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lecturamedidoreshogares.LogicaUI.MedicionViewModel
import com.example.lecturamedidoreshogares.R
import com.example.lecturamedidoreshogares.modelo.Medicion
import com.example.lecturamedidoreshogares.modelo.TipoGasto
import androidx.compose.ui.text.input.KeyboardType
import java.time.LocalDate
import androidx.compose.material3.Text as Material3Text

@Preview (showSystemUi = true, locale = "en", )
@Composable
 fun FormularioScreen(navController: NavController, viewModel: MedicionViewModel) {

    val contexto = LocalContext.current
    var valor by remember { mutableStateOf("") }
    var tipoSeleccionado by remember { mutableStateOf<TipoGasto?>(null) }
    var fecha by remember { mutableStateOf(LocalDate.now().toString()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top)
    ) {
        Material3Text(
            text = contexto.getString((R.string.app_name)),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlinedTextField(
            value = valor,
            onValueChange = { valor = it },
            label = {
                Material3Text( text = contexto.getString(R.string.lectura_medidor))} ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = {
                Material3Text (text = contexto.getString(R.string.fecha))},
            modifier = Modifier.fillMaxWidth()
        )
        Material3Text(text = contexto.getString(R.string.medidor), style = MaterialTheme.typography.bodyMedium)

        Column {
            TipoGasto.values().forEach { tipo ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RadioButton(
                        selected = tipoSeleccionado == tipo,
                        onClick = { tipoSeleccionado = tipo }
                    )
                    Material3Text(text = tipo.name.lowercase().replaceFirstChar { it.uppercase() })
                }
            }
        }
        Button(
            onClick = {
                if (valor.isNotBlank() && tipoSeleccionado != null) {
                    viewModel.agregarMedicion(
                        Medicion(
                            tipo = tipoSeleccionado!!,
                            valor = valor.toInt(),
                            fecha = fecha
                        )
                    ) {
                        navController.popBackStack()
                    }
                }
            },
            enabled = valor.isNotBlank() && tipoSeleccionado != null
        ) {
            Material3Text(text =  contexto.getString(R.string.btn_registrar))
        }
    }
}









