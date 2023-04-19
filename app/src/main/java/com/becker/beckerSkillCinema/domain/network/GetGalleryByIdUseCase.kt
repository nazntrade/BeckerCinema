package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetGalleryByIdUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun execute(filmId: Int, type: String, page: Int) =
        repository.getGalleryByFilmId(filmId, type, page)
}