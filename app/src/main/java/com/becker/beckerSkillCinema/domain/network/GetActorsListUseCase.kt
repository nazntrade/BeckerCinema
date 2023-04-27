package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.models.networkModels.staffByFilmId.ResponseStaffByFilmId
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetActorsListUseCase @Inject constructor(private val repository: CinemaRepository) {

    suspend fun execute(filmId: Int): List<ResponseStaffByFilmId> {
        return repository.getActorsByFilmId(filmId)
    }
}