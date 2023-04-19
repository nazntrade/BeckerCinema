package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem
import javax.inject.Inject

class GetPremierFilmUseCase @Inject constructor(
    private val repository: CinemaRepository
) {
    suspend fun execute(year: Int, month: String): List<HomeItem> {
        return repository.getFilmsPremier(year, month)
    }
}