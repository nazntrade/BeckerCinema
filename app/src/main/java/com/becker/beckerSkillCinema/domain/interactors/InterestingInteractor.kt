package com.becker.beckerSkillCinema.domain.interactors

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Interesting
import com.becker.beckerSkillCinema.domain.local.AddMovieToInterestingUseCase
import com.becker.beckerSkillCinema.domain.local.ClearInterestingUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllInterestingMoviesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InterestingInteractor @Inject constructor(
    private val addMovieToInterestingUseCase: AddMovieToInterestingUseCase,
    private val clearInterestingUseCase: ClearInterestingUseCase,
    private val getAllInterestingMoviesUseCase: GetAllInterestingMoviesUseCase
) {
    suspend fun addToInteresting(interesting: Interesting) {
        return addMovieToInterestingUseCase.execute(interesting)
    }

    suspend fun clearInteresting() {
        return clearInterestingUseCase.execute()
    }

    fun getAllInteresting(): Flow<List<Interesting>> {
        return getAllInterestingMoviesUseCase.execute()
    }
}