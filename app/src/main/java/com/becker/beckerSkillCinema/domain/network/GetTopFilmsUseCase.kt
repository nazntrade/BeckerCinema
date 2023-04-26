package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.models.uiModels.BasicUiMovieModel
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetTopFilmsUseCase @Inject constructor(
    private val cinemaRepository: CinemaRepository
) {
    suspend fun execute(topType: String, page: Int): List<BasicUiMovieModel> {
        return cinemaRepository.getFilmsTop(topType, page)
    }
}