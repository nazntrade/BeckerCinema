package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class DeleteMovieFromCustomCollectionUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(collectionName: String, movieId: Int) {
        return repositoryDataBase.deleteMovieFromCustomCollection(collectionName, movieId)
    }
}