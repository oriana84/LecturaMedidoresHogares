package com.example.lecturamedidoreshogares.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Medicion")
data class Medicion (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipo: TipoGasto,
    val valor: Int,
    val fecha: String
)
enum class TipoGasto{
    AGUA, LUZ, GAS;
}


