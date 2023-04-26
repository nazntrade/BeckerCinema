package com.becker.beckerSkillCinema.presentation.home.allFilmsByCategory.allFilmAdapters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.becker.beckerSkillCinema.data.ParamsFilterFilm
import com.becker.beckerSkillCinema.data.models.uiModels.BasicUiMovieModel
import com.becker.beckerSkillCinema.domain.network.GetFilmListUseCase

class FilmsByFilterPagingSource(
    private val filters: ParamsFilterFilm,
    private val getFilmListUseCase: GetFilmListUseCase
) : PagingSource<Int, BasicUiMovieModel>() {
    override fun getRefreshKey(state: PagingState<Int, BasicUiMovieModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BasicUiMovieModel> {
        val page = params.key ?: 1
        val pageSize = params.loadSize.coerceAtMost(20)

        val response = getFilmListUseCase.executeFilmsByFilterCount(filters, page)
        return if (response.total != 0) {
            val items = response.items
            val nextKey = if (items.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            LoadResult.Page(items, prevKey, nextKey)
        } else {
            LoadResult.Error(Exception())
        }
    }
}