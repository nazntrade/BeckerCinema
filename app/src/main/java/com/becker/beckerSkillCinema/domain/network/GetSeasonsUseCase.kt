package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetSeasonsUseCase @Inject constructor(private val repository: CinemaRepository) {
    suspend fun execute(seriesId: Int) = repository.getSeasonsById(seriesId)
}