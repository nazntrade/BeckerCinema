package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Watched
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class AddToWatchedUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(watched: Watched) {
        return repositoryDataBase.addToWatched(watched)
    }
}