package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.CustomCollection
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMoviesFromCustomCollectionUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    fun execute(): Flow<List<CustomCollection>> {
        return repositoryDataBase.getAllMoviesFromCustomCollection()
    }
}