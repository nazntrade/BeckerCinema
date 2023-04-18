package com.becker.beckerSkillCinema.domain

import com.becker.beckerSkillCinema.data.network.networkEntities.filmByFilter.ResponseGenresCountries
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetGenresCountriesUseCase @Inject constructor(private val repository: CinemaRepository) {
    suspend fun executeGenresCountries(): ResponseGenresCountries {
        return repository.getGenresCountries()
    }
}