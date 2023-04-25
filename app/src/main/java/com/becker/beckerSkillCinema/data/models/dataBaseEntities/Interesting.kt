package com.becker.beckerSkillCinema.data.models.dataBaseEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Interesting")
data class Interesting(
    @PrimaryKey
    @ColumnInfo(name = "interestingId")
    val interestingId: Int,
    @ColumnInfo(name = "dateAdded")
    val dateAdded: String
)