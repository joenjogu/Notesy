package com.joenjogu.notesy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
        @PrimaryKey
        val id: Int,
        val noteTitle: String,
        val noteText: String
)
