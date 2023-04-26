package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class ClearInterestingUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute() {
        return dataBaseRepository.clearInteresting()
    }
}