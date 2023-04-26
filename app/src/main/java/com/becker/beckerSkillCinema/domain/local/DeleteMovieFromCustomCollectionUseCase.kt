package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class DeleteMovieFromCustomCollectionUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(collectionName: String, movieId: Int) {
        return dataBaseRepository.deleteMovieFromCustomCollection(collectionName, movieId)
    }
}