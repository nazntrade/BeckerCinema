package com.becker.beckerSkillCinema.domain.interactors

import com.becker.beckerSkillCinema.data.models.localModels.ToWatch
import com.becker.beckerSkillCinema.domain.local.AddToWatchUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteFromToWatchUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllToWatchUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToWatchInteractor @Inject constructor(
    private val addToWatchUseCase: AddToWatchUseCase,
    private val deleteFromToWatchUseCase: DeleteFromToWatchUseCase,
    private val getAllToWatchUseCase: GetAllToWatchUseCase
) {
    suspend fun addToWatch(toWatch: ToWatch) {
        return addToWatchUseCase.execute(toWatch)
    }

    suspend fun deleteFromToWatch(movieId: Int) {
        return deleteFromToWatchUseCase.execute(movieId)
    }

    fun getAllToWatch(): Flow<List<ToWatch>> {
        return getAllToWatchUseCase.execute()
    }
}