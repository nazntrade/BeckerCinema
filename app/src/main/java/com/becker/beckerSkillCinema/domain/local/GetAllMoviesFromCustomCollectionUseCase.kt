package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.CustomCollection
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMoviesFromCustomCollectionUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    fun execute(): Flow<List<CustomCollection>> {
        return dataBaseRepository.getAllMoviesFromCustomCollection()
    }
}