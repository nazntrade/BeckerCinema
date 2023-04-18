package com.becker.beckerSkillCinema.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.ToWatch
import kotlinx.coroutines.flow.Flow

@Dao
interface ToWatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToWatch(vararg toWatch: ToWatch)

    @Query("SELECT * FROM ToWatch ORDER BY dateAdded DESC")
    fun getAllToWatch(): Flow<List<ToWatch>>

    @Query("DELETE FROM ToWatch WHERE toWatchId = :movieId")
    suspend fun deleteFromToWatch(movieId: Int)
}