package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Movie
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class AddMovieToDataBaseUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(movie: Movie) {
        return repositoryDataBase.addMovie(movie)
    }
}