package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.network.networkEntities.filmByFilter.ResponseGenresCountries
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetGenresCountriesUseCase @Inject constructor(private val repository: CinemaRepository) {
    suspend fun execute(): ResponseGenresCountries {
        return repository.getGenresCountries()
    }
}