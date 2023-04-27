package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.ParamsFilterFilm
import com.becker.beckerSkillCinema.data.models.networkModels.filmByFilter.FilmByFilter
import com.becker.beckerSkillCinema.data.models.networkModels.filmByFilter.ResponseByFilter
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetFilmListUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun executeFilmsByFilter(
        filters: ParamsFilterFilm,
        page: Int
    ): List<FilmByFilter> {
        return repository.getFilmsByFilter(
            filters = filters,
            page = page
        ).items
    }

    suspend fun executeFilmsByFilterCount(
        filters: ParamsFilterFilm,
        page: Int
    ): ResponseByFilter {
        return repository.getFilmsByFilter(filters, page)
    }
}