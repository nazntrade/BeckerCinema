package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class DeleteFromFavoritesUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(movieId: Int) {
        return repositoryDataBase.deleteFromFavorites(movieId)
    }
}