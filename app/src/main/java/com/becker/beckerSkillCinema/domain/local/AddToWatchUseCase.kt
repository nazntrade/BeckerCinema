package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.ToWatch
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class AddToWatchUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(toWatch: ToWatch) {
        return repositoryDataBase.addToWatch(toWatch)
    }
}