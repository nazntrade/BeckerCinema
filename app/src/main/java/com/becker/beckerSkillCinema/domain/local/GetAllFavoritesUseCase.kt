package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Favorites
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    fun execute(): Flow<List<Favorites>> {
        return repositoryDataBase.getAllFavorites()
    }
}