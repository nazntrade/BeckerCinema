package com.becker.beckerSkillCinema.domain.network

import com.becker.beckerSkillCinema.data.network.networkEntities.personFromSearch.ResponsePeopleFromSearch
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import javax.inject.Inject

class GetPeopleFromSearchUseCase @Inject constructor(
    private val repository: CinemaRepository
) {
    suspend fun execute(name: String, page: Int): ResponsePeopleFromSearch {
        return repository.getPeopleFromSearch(name, page)
    }
}