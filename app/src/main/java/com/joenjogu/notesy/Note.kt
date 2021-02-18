package com.joenjogu.notesy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val noteTitle: String,
        val noteText: String
)
