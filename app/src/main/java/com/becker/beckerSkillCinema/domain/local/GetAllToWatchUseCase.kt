package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.ToWatch
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllToWatchUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    fun execute(): Flow<List<ToWatch>> {
        return repositoryDataBase.getAllToWatch()
    }
}