package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class ClearInterestingUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute() {
        return repositoryDataBase.clearInteresting()
    }
}