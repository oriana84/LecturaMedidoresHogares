package com.example.lecturamedidoreshogares.Persistencia

import androidx.room.TypeConverter
import com.example.lecturamedidoreshogares.modelo.TipoGasto

class converters {
    @TypeConverter
    fun deTipoGasto(tipo: TipoGasto): String = tipo.name

    @TypeConverter
    fun aTipoGasto(valor: String): TipoGasto = TipoGasto.valueOf(valor)
}
