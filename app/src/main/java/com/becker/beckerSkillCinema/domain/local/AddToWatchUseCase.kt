package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.ToWatch
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class AddToWatchUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(toWatch: ToWatch) {
        return dataBaseRepository.addToWatch(toWatch)
    }
}