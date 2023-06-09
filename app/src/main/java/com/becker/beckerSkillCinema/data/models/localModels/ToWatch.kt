package com.becker.beckerSkillCinema.data.models.localModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToWatch")
data class ToWatch(
    @PrimaryKey
    @ColumnInfo(name = "toWatchId")
    val toWatchId: Int,
    @ColumnInfo(name = "dateAdded")
    val dateAdded: String
)
