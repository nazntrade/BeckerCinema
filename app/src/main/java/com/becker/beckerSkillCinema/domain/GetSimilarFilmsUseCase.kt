package com.becker.beckerSkillCinema.domain

import com.becker.beckerSkillCinema.data.network.networkEntities.similarFilm.ResponseSimilarFilms
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetSimilarFilmsUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun executeSimilarFilms(filmId: Int): ResponseSimilarFilms {
        return repository.getSimilarByFilmId(filmId)
    }
}