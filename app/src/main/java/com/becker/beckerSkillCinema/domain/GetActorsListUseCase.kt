package com.becker.beckerSkillCinema.domain

import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import com.becker.beckerSkillCinema.data.entities.staffByFilmId.ResponseStaffByFilmId
import javax.inject.Inject

class GetActorsListUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun executeActorsList(filmId: Int): List<ResponseStaffByFilmId> {
        return repository.getActorsByFilmId(filmId)
    }
}