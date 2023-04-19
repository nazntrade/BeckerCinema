package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.network.networkEntities.staffById.ResponseStaffById
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetStaffByIdUseCase @Inject constructor(
    private val repository: CinemaRepository
) {
    suspend fun execute(staffId: Int): ResponseStaffById {
        return repository.getStaffById(staffId)
    }
}