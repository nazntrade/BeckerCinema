package com.becker.beckerSkillCinema.data.models.networkEntities.staffById

import com.becker.beckerSkillCinema.data.models.uiModels.BasicUiMovieModel
import com.becker.beckerSkillCinema.data.models.networkEntities.filmByFilter.Genre
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StaffsFilms(
    @Json(name = "filmId") override val filmId: Int,
    @Json(name = "nameRu") override val nameRu: String?,
    @Json(name = "nameEn") val nameEn: String?,
    @Json(name = "rating") override val rating: String?,
    @Json(name = "general") val general: Boolean,
    @Json(name = "description") val description: String?,
    @Json(name = "professionKey") val professionKey: String,
    override val yearHomeItem: String?
) : BasicUiMovieModel {
    override val posterUrlPreview: String = ""
    override val genres: List<Genre> = emptyList()
}