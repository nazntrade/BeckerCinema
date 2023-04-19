package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Interesting
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllInterestingMoviesUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    fun execute(): Flow<List<Interesting>> {
        return repositoryDataBase.getAllInterestingMovies()
    }
}