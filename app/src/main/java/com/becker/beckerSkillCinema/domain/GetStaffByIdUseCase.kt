package com.becker.beckerSkillCinema.domain

import com.becker.beckerSkillCinema.data.network.networkEntities.staffById.ResponseStaffById
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetStaffByIdUseCase @Inject constructor(
    private val repository: CinemaRepository
) {
    suspend fun executeStaffById(staffId: Int): ResponseStaffById {
        return repository.getStaffById(staffId)
    }
}