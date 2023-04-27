package com.becker.beckerSkillCinema.data.repositories

import com.becker.beckerSkillCinema.data.CategoriesFilms
import com.becker.beckerSkillCinema.data.DataCentre
import com.becker.beckerSkillCinema.data.ParamsFilterFilm
import com.becker.beckerSkillCinema.data.models.uiModels.BasicUiMovieModel
import com.becker.beckerSkillCinema.data.models.networkModels.filmByFilter.ResponseByFilter
import com.becker.beckerSkillCinema.data.models.networkModels.filmByFilter.ResponseGenresCountries
import com.becker.beckerSkillCinema.data.models.networkModels.filmsPremier.FilmPremier
import com.becker.beckerSkillCinema.data.network.ApiServiceKinopoisk
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CinemaRepository @Inject constructor(
    private val api: ApiServiceKinopoisk
) {

    // FragmentHome
    suspend fun getFilmsTop(topType: String, page: Int): List<BasicUiMovieModel> {
        return api.getFilmsTop(type = topType, page = page).films
    }

    suspend fun getFilmsPremier(year: Int, month: String): List<FilmPremier> {
        return api.getPremier(year, month).items
    }

    // FragmentSearch
    suspend fun getFilmsByFilter(filters: ParamsFilterFilm, page: Int): ResponseByFilter {
        return api.getFilmsByFilter(
            countries = if (filters.countries.isNotEmpty()) filters.countries.keys.first()
                .toString() else "",
            genres = if (filters.genres.isNotEmpty()) filters.genres.keys.first()
                .toString() else "",
            order = filters.order,
            type = filters.type,
            ratingFrom = filters.ratingFrom,
            ratingTo = filters.ratingTo,
            yearFrom = filters.yearFrom,
            yearTo = filters.yearTo,
            imdbId = filters.imdbId,
            keyword = filters.keyword,
            page = page
        )
    }

    suspend fun getGenresCountries(): ResponseGenresCountries {
        return api.getGenresCountries()
    }

    suspend fun getFilmById(filmId: Int) =
        api.getCurrentFilm(filmId)

    suspend fun getSeasonsById(seriesId: Int) =
        api.getSeasons(seriesId)

    suspend fun getActorsByFilmId(filmId: Int) =
        api.getActors(filmId)

    suspend fun getGalleryByFilmId(filmId: Int, type: String, page: Int) =
        api.getFilmImages(filmId, type, page)

    suspend fun getSimilarByFilmId(filmId: Int) =
        api.getSimilarFilms(filmId)

    suspend fun getStaffById(staffId: Int) =
        api.getStaff(staffId)

    suspend fun getPeopleFromSearch(name: String, page: Int) =
        api.getPeopleFromSearch(name, page)

    fun putFilmId(filmId: Int) = DataCentre.putCurrentFilmId(filmId)

    fun getCurrentFilmId() = DataCentre.getCurrentFilmId()

    fun putCategory(it: CategoriesFilms) = DataCentre.putCategory(it)

    fun getCurrentCategory() = DataCentre.getCurrentCategory()
}