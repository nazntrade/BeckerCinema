package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.CustomCollection
import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class AddMovieToCustomCollectionUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(customCollection: CustomCollection) {
        return repositoryDataBase.addMovieToCustomCollection(customCollection)
    }
}