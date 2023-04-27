package com.becker.beckerSkillCinema.data.models.networkModels.seasons

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseSeasons(
    @Json(name = "total") val total: Int,
    @Json(name = "items") val items: List<Season>
)