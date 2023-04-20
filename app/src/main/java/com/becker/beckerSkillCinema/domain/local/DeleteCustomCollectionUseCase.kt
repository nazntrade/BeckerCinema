package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.RepositoryDataBase
import javax.inject.Inject

class DeleteCustomCollectionUseCase @Inject constructor(
    private val repositoryDataBase: RepositoryDataBase
) {
    suspend fun execute(collectionName: String) {
        return repositoryDataBase.deleteCustomCollection(collectionName)
    }
}