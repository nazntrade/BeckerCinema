package com.becker.beckerSkillCinema.domain.interactors

import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Watched
import com.becker.beckerSkillCinema.domain.local.AddToWatchedUseCase
import com.becker.beckerSkillCinema.domain.local.ClearWatchedUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteFromWatchedUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllWatchedUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WatchedInteractor @Inject constructor(
    private val addToWatchedUseCase: AddToWatchedUseCase,
    private val clearWatchedUseCase: ClearWatchedUseCase,
    private val getAllWatchedUseCase: GetAllWatchedUseCase,
    private val deleteFromWatchedUseCase: DeleteFromWatchedUseCase
) {
    suspend fun addToWatched(watched: Watched) {
        return addToWatchedUseCase.execute(watched)
    }

    suspend fun clearWatched() {
        return clearWatchedUseCase.execute()
    }

    fun getAllWatched(): Flow<List<Watched>> {
        return getAllWatchedUseCase.execute()
    }

    suspend fun deleteFromWatched(movieId: Int) {
        return deleteFromWatchedUseCase.execute(movieId)
    }
}