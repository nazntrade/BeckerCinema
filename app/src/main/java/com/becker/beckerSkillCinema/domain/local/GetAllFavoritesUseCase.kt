package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.localModels.Favorites
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    fun execute(): Flow<List<Favorites>> {
        return dataBaseRepository.getAllFavorites()
    }
}