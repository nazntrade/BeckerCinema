package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.models.uiModels.BasicUiMovieModel
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetPremierFilmUseCase @Inject constructor(
    private val repository: CinemaRepository
) {
    suspend fun execute(year: Int, month: String): List<BasicUiMovieModel> {
        return repository.getFilmsPremier(year, month)
    }
}