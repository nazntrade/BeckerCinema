package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.Watched
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class AddToWatchedUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(watched: Watched) {
        return dataBaseRepository.addToWatched(watched)
    }
}