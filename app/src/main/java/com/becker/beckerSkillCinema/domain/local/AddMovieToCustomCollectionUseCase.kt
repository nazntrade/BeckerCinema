package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.CustomCollection
import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class AddMovieToCustomCollectionUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(customCollection: CustomCollection) {
        return dataBaseRepository.addMovieToCustomCollection(customCollection)
    }
}