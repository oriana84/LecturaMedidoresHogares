package com.example.lecturamedidoreshogares.LogicaUI

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.lecturamedidoreshogares.Persistencia.AppDatabase
import com.example.lecturamedidoreshogares.modelo.Medicion

class MedicionViewModel (application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getInstance(application).medicionDao()
     val lista = mutableStateOf<List<Medicion>>(emptyList())

    fun cargarMediciones() {
        viewModelScope.launch {
            lista.value = dao.obtenerTodas()
        }
    }
    fun agregarMedicion(medicion: Medicion, onDone: () -> Unit) {
        viewModelScope.launch {
            dao.insertar(medicion)
            cargarMediciones()
            onDone()
        }
    }
}