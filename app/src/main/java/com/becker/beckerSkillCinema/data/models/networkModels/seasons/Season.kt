package com.becker.beckerSkillCinema.data.models.networkModels.seasons

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Season(
    @Json(name = "number") val number: Int,
    @Json(name = "episodes") val episodes: List<Episode>
)