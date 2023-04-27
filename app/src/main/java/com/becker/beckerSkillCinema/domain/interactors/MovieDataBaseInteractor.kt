package com.becker.beckerSkillCinema.domain.interactors

import com.becker.beckerSkillCinema.data.models.localModels.Movie
import com.becker.beckerSkillCinema.domain.local.AddMovieToDataBaseUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllLocalMoviesUseCase
import com.becker.beckerSkillCinema.domain.local.GetMovieFromDataBaseByIdUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDataBaseInteractor @Inject constructor(
    private val addMovieToDataBaseUseCase: AddMovieToDataBaseUseCase,
    private val getMovieFromDataBaseByIdUseCase: GetMovieFromDataBaseByIdUseCase,
    private val getAllLocalMoviesUseCase: GetAllLocalMoviesUseCase
) {
    suspend fun addMovieToDataBase(movie: Movie) {
        return addMovieToDataBaseUseCase.execute(movie)
    }

    suspend fun getMovieFromDataBaseById(movieId: Int): Movie {
        return getMovieFromDataBaseByIdUseCase.execute(movieId)
    }

    fun getAllLocalMovies(): Flow<List<Movie>> {
        return getAllLocalMoviesUseCase.execute()
    }
}