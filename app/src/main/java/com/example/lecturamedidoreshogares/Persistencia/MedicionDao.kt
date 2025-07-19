package com.example.lecturamedidoreshogares.Persistencia

import androidx.room.*
import com.example.lecturamedidoreshogares.modelo.Medicion

@Dao
interface MedicionDao {
    @Query("SELECT * FROM Medicion ORDER BY fecha DESC")
    suspend fun obtenerTodas(): List<Medicion>

    @Insert
    suspend fun insertar(medicion: Medicion)
}