package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.Interesting
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllInterestingMoviesUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    fun execute(): Flow<List<Interesting>> {
        return dataBaseRepository.getAllInterestingMovies()
    }
}