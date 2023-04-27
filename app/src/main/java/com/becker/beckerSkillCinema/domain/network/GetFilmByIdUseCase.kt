package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.models.networkModels.filmById.ResponseCurrentFilm
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetFilmByIdUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun execute(filmId: Int): ResponseCurrentFilm {
        return repository.getFilmById(filmId)
    }
}