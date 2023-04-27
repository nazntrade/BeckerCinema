package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.Watched
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllWatchedUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    fun execute(): Flow<List<Watched>> {
        return dataBaseRepository.getAllWatched()
    }
}