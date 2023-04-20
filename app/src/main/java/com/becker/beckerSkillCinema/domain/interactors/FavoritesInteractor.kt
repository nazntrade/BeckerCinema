package com.becker.beckerSkillCinema.domain.interactors

import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Favorites
import com.becker.beckerSkillCinema.domain.local.AddToFavoritesUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteFromFavoritesUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllFavoritesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesInteractor @Inject constructor(
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val deleteFromFavoritesUseCase: DeleteFromFavoritesUseCase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase
    ) {
    suspend fun addToFavorites(favorites: Favorites) {
        return addToFavoritesUseCase.execute(favorites)
    }

    suspend fun deleteFromFavorites(movieId: Int) {
        return deleteFromFavoritesUseCase.execute(movieId)
    }

    fun getAllFavorites(): Flow<List<Favorites>> {
        return getAllFavoritesUseCase.execute()
    }
}