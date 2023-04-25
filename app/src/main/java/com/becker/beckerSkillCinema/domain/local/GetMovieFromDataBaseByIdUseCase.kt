package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Movie
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class GetMovieFromDataBaseByIdUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(movieId: Int): Movie {
        return repositoryDataBase.getMovieById(movieId)
    }
}