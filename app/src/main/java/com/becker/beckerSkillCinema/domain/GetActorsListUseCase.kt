package com.becker.beckerSkillCinema.domain

import com.becker.beckerSkillCinema.data.network.networkEntities.staffByFilmId.ResponseStaffByFilmId
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetActorsListUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun executeActorsList(filmId: Int): List<ResponseStaffByFilmId> {
        return repository.getActorsByFilmId(filmId)
    }
}