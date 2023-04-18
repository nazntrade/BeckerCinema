package com.becker.beckerSkillCinema.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Interesting
import kotlinx.coroutines.flow.Flow

@Dao
interface InterestingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToInteresting(vararg interesting: Interesting)

    @Query("SELECT * FROM Interesting ORDER BY dateAdded DESC")
    fun getAllInteresting(): Flow<List<Interesting>>

    @Query("DELETE FROM Interesting")
    suspend fun clearInteresting()
}