package com.becker.beckerSkillCinema.data.models.uiModels

import com.becker.beckerSkillCinema.data.models.networkEntities.filmByFilter.Genre

interface BasicUiMovieModel {
    val filmId: Int
    val posterUrlPreview: String
    val nameRu: String?
    val rating: String?
    val genres: List<Genre>
    val yearHomeItem: String?
}