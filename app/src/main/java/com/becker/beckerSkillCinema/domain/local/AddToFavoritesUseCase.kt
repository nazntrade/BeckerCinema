package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Favorites
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class AddToFavoritesUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(favorites: Favorites) {
        return repositoryDataBase.addToFavorites(favorites)
    }
}