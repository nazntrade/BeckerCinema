package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.Favorites
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class AddToFavoritesUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(favorites: Favorites) {
        return dataBaseRepository.addToFavorites(favorites)
    }
}