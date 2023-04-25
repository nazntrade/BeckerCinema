package com.becker.beckerSkillCinema.domain.interactors

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.CustomCollection
import com.becker.beckerSkillCinema.domain.local.AddMovieToCustomCollectionUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteCustomCollectionUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteMovieFromCustomCollectionUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllMoviesFromCustomCollectionUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomCollectionInteractor @Inject constructor(
    private val addMovieToCustomCollectionUseCase: AddMovieToCustomCollectionUseCase,
    private val deleteMovieFromCustomCollectionUseCase: DeleteMovieFromCustomCollectionUseCase,
    private val getAllMoviesFromCustomCollectionUseCase: GetAllMoviesFromCustomCollectionUseCase,
    private val deleteCustomCollectionUseCase: DeleteCustomCollectionUseCase
) {
    suspend fun addMovieToCustomCollection(customCollection: CustomCollection) {
        return addMovieToCustomCollectionUseCase.execute(customCollection)
    }

    suspend fun deleteMovieFromCustomCollection(collectionName: String, movieId: Int) {
        return deleteMovieFromCustomCollectionUseCase.execute(collectionName, movieId)
    }

    fun getAllMoviesFromCustomCollection(): Flow<List<CustomCollection>> {
        return getAllMoviesFromCustomCollectionUseCase.execute()
    }

    suspend fun deleteCustomCollection(collectionName: String) {
        deleteCustomCollectionUseCase.execute(collectionName)
    }
}