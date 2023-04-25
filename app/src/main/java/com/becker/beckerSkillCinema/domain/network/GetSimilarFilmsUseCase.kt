package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.models.networkEntities.similarFilm.ResponseSimilarFilms
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetSimilarFilmsUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun execute(filmId: Int): ResponseSimilarFilms {
        return repository.getSimilarByFilmId(filmId)
    }
}