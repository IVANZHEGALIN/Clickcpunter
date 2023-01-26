package com.example.clickcpunter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(
    @PrimaryKey
    val id: Int,
    val count: Int?
)