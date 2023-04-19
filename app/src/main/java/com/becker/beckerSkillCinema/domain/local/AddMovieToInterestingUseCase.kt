package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Interesting
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class AddMovieToInterestingUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(interesting: Interesting) {
        return repositoryDataBase.addMovieToInteresting(interesting)
    }
}