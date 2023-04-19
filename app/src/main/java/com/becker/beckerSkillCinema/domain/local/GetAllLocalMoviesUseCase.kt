package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Movie
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllLocalMoviesUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    fun execute(): Flow<List<Movie>> {
        return repositoryDataBase.getAllMovies()
    }
}