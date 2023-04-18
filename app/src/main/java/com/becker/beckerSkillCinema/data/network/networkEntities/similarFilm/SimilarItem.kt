package com.becker.beckerSkillCinema.data.network.networkEntities.similarFilm

import com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem
import com.becker.beckerSkillCinema.data.network.networkEntities.filmByFilter.Genre
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SimilarItem(
    @Json(name = "filmId") override val filmId: Int,
    @Json(name = "nameRu") override val nameRu: String,
    @Json(name = "nameEn") val nameEn: String?,
    @Json(name = "nameOriginal") val nameOriginal: String?,
    @Json(name = "posterUrl") val posterUrl: String,
    @Json(name = "posterUrlPreview") override val posterUrlPreview: String,
    @Json(name = "relationType") val relationType: String,
    override val yearHomeItem: String?
) : HomeItem {
    override val rating: String? = null
    override val genres: List<Genre> = emptyList()
}