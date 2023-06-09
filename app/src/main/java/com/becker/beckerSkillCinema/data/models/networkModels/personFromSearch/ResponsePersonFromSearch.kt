package com.becker.beckerSkillCinema.data.models.networkModels.personFromSearch

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponsePeopleFromSearch(
    @Json(name = "items") val items: List<PeopleFromSearch>,
    @Json(name = "total") val total: Int
)