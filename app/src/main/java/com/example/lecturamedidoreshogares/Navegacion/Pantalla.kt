package com.example.lecturamedidoreshogares.Navegacion

sealed class Pantalla (val ruta: String) {
    data object Listado : Pantalla("listado")
    data object Formulario : Pantalla("formulario")
}
