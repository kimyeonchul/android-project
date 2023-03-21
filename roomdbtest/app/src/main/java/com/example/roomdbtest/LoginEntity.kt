package com.example.roomdbtest

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.PipedWriter

@Entity
data class LoginEntity(
    val username: String,
    val password: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}