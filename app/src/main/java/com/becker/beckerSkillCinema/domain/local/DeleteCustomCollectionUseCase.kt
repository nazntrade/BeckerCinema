package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.repositories.DataBaseRepository
import javax.inject.Inject

class DeleteCustomCollectionUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend fun execute(collectionName: String) {
        return dataBaseRepository.deleteCustomCollection(collectionName)
    }
}