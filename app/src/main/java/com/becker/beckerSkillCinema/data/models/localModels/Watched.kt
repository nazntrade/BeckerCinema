package com.becker.beckerSkillCinema.data.models.localModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Watched")
data class Watched(
    @PrimaryKey
    @ColumnInfo(name = "watchedId")
    val watchedId: Int,
    @ColumnInfo(name = "dateAdded")
    val dateAdded: String
)
