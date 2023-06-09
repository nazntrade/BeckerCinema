package com.becker.beckerSkillCinema.presentation.home.allFilmsByCategory.allFilmAdapters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.becker.beckerSkillCinema.data.CategoriesFilms
import com.becker.beckerSkillCinema.data.ParamsFilterFilm
import com.becker.beckerSkillCinema.data.models.uiModels.BasicUiMovieModel
import com.becker.beckerSkillCinema.domain.network.GetFilmListUseCase
import com.becker.beckerSkillCinema.domain.network.GetPremierFilmUseCase
import com.becker.beckerSkillCinema.domain.network.GetTopFilmsUseCase
import com.becker.beckerSkillCinema.presentation.home.HomeViewModel.Companion.GENRE_BIOGRAPHY_FILTER
import com.becker.beckerSkillCinema.presentation.home.HomeViewModel.Companion.GENRE_CARTOONS_FILTER
import com.becker.beckerSkillCinema.presentation.home.HomeViewModel.Companion.GENRE_SCIENCE_FICTION_FILTER
import com.becker.beckerSkillCinema.utils.ConstantsAndParams.TOP_TYPES

private const val FIRST_PAGE = 1

class AllFilmPagingSource(
    private val categoriesFilms: CategoriesFilms,
    private val year: Int,
    private val month: String,
    private val getPremierFilmUseCase: GetPremierFilmUseCase,
    private val getTopFilmsUseCase: GetTopFilmsUseCase,
    private val getFilmListUseCase: GetFilmListUseCase
) : PagingSource<Int, BasicUiMovieModel>() {
    override fun getRefreshKey(state: PagingState<Int, BasicUiMovieModel>): Int =
        FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BasicUiMovieModel> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            when (categoriesFilms) {
                CategoriesFilms.PREMIERS -> {
                    getPremierFilmUseCase.execute(year, month)
                }

                CategoriesFilms.POPULAR_100 -> {
                    getTopFilmsUseCase.execute(
                        topType = TOP_TYPES.getValue(CategoriesFilms.POPULAR_100),
                        page = page
                    )
                }

                CategoriesFilms.BEST_250 -> {
                    getTopFilmsUseCase.execute(
                        topType = TOP_TYPES.getValue(CategoriesFilms.BEST_250),
                        page = page
                    )
                }

                CategoriesFilms.TV_SERIES -> {
                    getFilmListUseCase.executeFilmsByFilter(
                        filters = ParamsFilterFilm(
                            type = TOP_TYPES.getValue(CategoriesFilms.TV_SERIES),
                            ratingFrom = 7
                        ),
                        page = page
                    )
                }

                CategoriesFilms.MOST_AWAIT -> {
                    getTopFilmsUseCase.execute(
                        topType = TOP_TYPES.getValue(CategoriesFilms.MOST_AWAIT),
                        page = page
                    )
                }

                CategoriesFilms.BIOGRAPHY -> {
                    getFilmListUseCase.executeFilmsByFilter(
                        filters = ParamsFilterFilm(
                            type = TOP_TYPES.getValue(CategoriesFilms.BIOGRAPHY),
                            genres = GENRE_BIOGRAPHY_FILTER,
                            ratingFrom = 7
                        ),
                        page = page
                    )
                }

                CategoriesFilms.SCIENCE_FICTION -> {
                    getFilmListUseCase.executeFilmsByFilter(
                        filters = ParamsFilterFilm(
                            type = TOP_TYPES.getValue(CategoriesFilms.SCIENCE_FICTION),
                            genres = GENRE_SCIENCE_FICTION_FILTER,
                            ratingFrom = 7
                        ),
                        page = page
                    )
                }

                CategoriesFilms.CARTOONS -> {
                    getFilmListUseCase.executeFilmsByFilter(
                        filters = ParamsFilterFilm(
                            type = TOP_TYPES.getValue(CategoriesFilms.CARTOONS),
                            genres = GENRE_CARTOONS_FILTER,
                            ratingFrom = 7
                        ),
                        page = page
                    )
                }
            }
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }
}