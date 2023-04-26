package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class DeleteFromToWatchUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(movieId: Int) {
        return dataBaseRepository.deleteFromToWatch(movieId)
    }
}