package com.example.lecturamedidoreshogares.Persistencia

import android.content.Context
import androidx.room.*

import com.example.lecturamedidoreshogares.modelo.Medicion

@Database(entities = [Medicion::class], version = 1)
@TypeConverters(converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicionDao(): MedicionDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "mediciones_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}

