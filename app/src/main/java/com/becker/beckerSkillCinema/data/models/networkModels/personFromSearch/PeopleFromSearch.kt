package com.becker.beckerSkillCinema.data.models.networkModels.personFromSearch

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PeopleFromSearch(
    @Json(name = "kinopoiskId") val kinopoiskId: Int,
    @Json(name = "nameEn") val nameEn: String?,
    @Json(name = "nameRu") val nameRu: String?,
    @Json(name = "posterUrl") val posterUrl: String
)