package com.becker.beckerSkillCinema.data.network.networkEntities.filmsPremier

import com.becker.beckerSkillCinema.data.network.networkEntities.filmByFilter.Country
import com.becker.beckerSkillCinema.data.network.networkEntities.filmByFilter.Genre
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmPremier(
    @Json(name = "kinopoiskId") override val filmId: Int,
    @Json(name = "posterUrlPreview") override val posterUrlPreview: String,
    @Json(name = "nameRu") override val nameRu: String,
    @Json(name = "genres") override val genres: List<Genre>,
    @Json(name = "nameEn") val nameEn: String,
    @Json(name = "countries") val countries: List<Country>,
    @Json(name = "duration") val duration: Int?,
    @Json(name = "posterUrl") val posterUrl: String,
    @Json(name = "premiereRu") val premiereRu: String,
    @Json(name = "year") val year: Int
) : com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem {
    override val rating: String? = null
    override val yearHomeItem: String = year.toString()
}