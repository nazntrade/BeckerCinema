package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Interesting
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class AddMovieToInterestingUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(interesting: Interesting) {
        return dataBaseRepository.addMovieToInteresting(interesting)
    }
}