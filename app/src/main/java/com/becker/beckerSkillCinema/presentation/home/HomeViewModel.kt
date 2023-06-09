package com.becker.beckerSkillCinema.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.becker.beckerSkillCinema.data.CategoriesFilms
import com.becker.beckerSkillCinema.data.GenreFilter
import com.becker.beckerSkillCinema.data.HomeList
import com.becker.beckerSkillCinema.data.ParamsFilterFilm
import com.becker.beckerSkillCinema.data.repositories.CinemaRepository
import com.becker.beckerSkillCinema.domain.network.GetFilmListUseCase
import com.becker.beckerSkillCinema.domain.network.GetPremierFilmUseCase
import com.becker.beckerSkillCinema.domain.network.GetTopFilmsUseCase
import com.becker.beckerSkillCinema.presentation.StateLoading
import com.becker.beckerSkillCinema.utils.ConstantsAndParams.TOP_TYPES
import com.becker.beckerSkillCinema.utils.toLimitTheNumberOfObjects
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.Month
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopFilmsUseCase: GetTopFilmsUseCase,
    private val getPremierFilmUseCase: GetPremierFilmUseCase,
    private val getFilmListUseCase: GetFilmListUseCase,
    private val repository: CinemaRepository
) : ViewModel() {

    private val currentMonth: String = Month.of(calendar.get(Calendar.MONTH) + 1).name
    private val currentYear: Int = calendar.get(Calendar.YEAR)

    private val _homePageFilmList = MutableStateFlow<List<HomeList>>(emptyList())
    val homePageFilmList = _homePageFilmList.asStateFlow()

    private val _loadCategoryState = MutableStateFlow<StateLoading>(StateLoading.Default)
    val loadCategoryState = _loadCategoryState.asStateFlow()

    init {
        getFilmsByCategories()
    }

    fun putFilmId(filmId: Int) {
        repository.putFilmId(filmId)
    }

    fun putCategory(outComeCategory: CategoriesFilms) {
        repository.putCategory(outComeCategory)
    }

    fun getFilmsByCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loadCategoryState.value = StateLoading.Loading
                val homeLists = listOf(
                    HomeList(
                        category = CategoriesFilms.PREMIERS,
                        filmList = getPremierFilmUseCase.execute(
                            year = currentYear,
                            month = currentMonth
                        ).toLimitTheNumberOfObjects(20)
                    ),
                    HomeList(
                        category = CategoriesFilms.POPULAR_100,
                        filmList = getTopFilmsUseCase.execute(
                            topType = TOP_TYPES.getValue(CategoriesFilms.POPULAR_100),
                            page = 1
                        )
                    ),
                    HomeList(
                        category = CategoriesFilms.BEST_250,
                        filmList = getTopFilmsUseCase.execute(
                            topType = TOP_TYPES.getValue(CategoriesFilms.BEST_250),
                            page = 1
                        )
                    ),
                    HomeList(
                        category = CategoriesFilms.TV_SERIES,
                        filmList = getFilmListUseCase.executeFilmsByFilter(
                            filters = ParamsFilterFilm(
                                type = TOP_TYPES.getValue(CategoriesFilms.TV_SERIES),
                                ratingFrom = 7
                            ),
                            page = 1
                        )
                    ),
                    HomeList(
                        category = CategoriesFilms.MOST_AWAIT,
                        filmList = getTopFilmsUseCase.execute(
                            topType = TOP_TYPES.getValue(CategoriesFilms.MOST_AWAIT),
                            page = 1
                        )
                    ),
                    HomeList(
                        category = CategoriesFilms.BIOGRAPHY,
                        filmList = getFilmListUseCase.executeFilmsByFilter(
                            filters = ParamsFilterFilm(
                                type = TOP_TYPES.getValue(CategoriesFilms.BIOGRAPHY),
                                genres = GENRE_BIOGRAPHY_FILTER,
                                ratingFrom = 7
                            ),
                            page = 1
                        )
                    ),
                    HomeList(
                        category = CategoriesFilms.SCIENCE_FICTION,
                        filmList = getFilmListUseCase.executeFilmsByFilter(
                            filters = ParamsFilterFilm(
                                type = TOP_TYPES.getValue(CategoriesFilms.SCIENCE_FICTION),
                                genres = GENRE_SCIENCE_FICTION_FILTER,
                                ratingFrom = 7
                            ),
                            page = 1
                        )
                    ),
                    HomeList(
                        category = CategoriesFilms.CARTOONS,
                        filmList = getFilmListUseCase.executeFilmsByFilter(
                            filters = ParamsFilterFilm(
                                type = TOP_TYPES.getValue(CategoriesFilms.CARTOONS),
                                genres = GENRE_CARTOONS_FILTER,
                                ratingFrom = 7
                            ),
                            page = 1
                        )
                    )
                )
                _homePageFilmList.value = homeLists
                _loadCategoryState.value = StateLoading.Success
            } catch (e: Throwable) {
                _loadCategoryState.value = StateLoading.Error(e.message.toString())
            }
        }
    }

    companion object {
        private val calendar: Calendar = Calendar.getInstance()
        val currentMonth: String = Month.of(calendar.get(Calendar.MONTH) + 1).name
        val currentYear: Int = calendar.get(Calendar.YEAR)

        val GENRE_BIOGRAPHY_FILTER = mapOf(
            GenreFilter.GENRE_BIOGRAPHY.code to TOP_TYPES.getValue(CategoriesFilms.BIOGRAPHY)
        )
        val GENRE_SCIENCE_FICTION_FILTER = mapOf(
            GenreFilter.GENRE_SCIENCE_FICTION.code to TOP_TYPES.getValue(CategoriesFilms.SCIENCE_FICTION)
        )
        val GENRE_CARTOONS_FILTER = mapOf(
            GenreFilter.GENRE_CARTOONS.code to TOP_TYPES.getValue(CategoriesFilms.CARTOONS)
        )
    }
}