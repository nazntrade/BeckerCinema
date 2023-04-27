package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.Movie
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class GetMovieFromDataBaseByIdUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(movieId: Int): Movie {
        return dataBaseRepository.getMovieById(movieId)
    }
}