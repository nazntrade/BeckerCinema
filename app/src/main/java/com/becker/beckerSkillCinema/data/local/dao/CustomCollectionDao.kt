package com.becker.beckerSkillCinema.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.becker.beckerSkillCinema.data.models.localModels.CustomCollection
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomCollectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieToCustomCollection(vararg customCollection: CustomCollection)

    @Query("SELECT * FROM CustomCollection ORDER BY dateAdded DESC")
    fun getAllMoviesFromCustomCollection(): Flow<List<CustomCollection>>

    @Query("DELETE FROM CustomCollection WHERE collectionName =:collectionName AND movieId = :movieId")
    suspend fun deleteMovieFromCustomCollection(collectionName: String, movieId: Int)

    @Query("DELETE FROM CustomCollection WHERE collectionName =:collectionName")
    suspend fun deleteCustomCollection(collectionName: String)
}