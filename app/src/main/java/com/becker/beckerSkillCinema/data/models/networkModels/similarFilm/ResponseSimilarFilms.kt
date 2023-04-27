package com.becker.beckerSkillCinema.data.models.networkModels.similarFilm

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseSimilarFilms(
    @Json(name = "items") val items: List<SimilarItem>?,
    @Json(name = "total") val total: Int
)