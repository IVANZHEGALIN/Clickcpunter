package com.example.clickcpunter

import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query


@androidx.room.Dao
interface Dao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(ent: Entity)
    @Query("SELECT * FROM entity")
    suspend fun getAll() : List<Entity>
}