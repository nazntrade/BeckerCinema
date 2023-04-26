package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Movie
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllLocalMoviesUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    fun execute(): Flow<List<Movie>> {
        return dataBaseRepository.getAllMovies()
    }
}