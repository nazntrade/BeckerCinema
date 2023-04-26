package com.becker.beckerSkillCinema.data.models.networkEntities.filmByFilter

import com.becker.beckerSkillCinema.data.models.uiModels.FilterCountryGenre
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilterGenre(
    @Json(name = "id") override val id: Int,
    @Json(name = "genre") override val name: String
) : FilterCountryGenre
