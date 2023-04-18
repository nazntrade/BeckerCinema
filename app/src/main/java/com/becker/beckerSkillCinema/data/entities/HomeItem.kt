package com.becker.beckerSkillCinema.data.entities

import com.becker.beckerSkillCinema.data.entities.filmByFilter.Genre

interface HomeItem {
    val filmId: Int
    val posterUrlPreview: String
    val nameRu: String?
    val rating: String?
    val genres: List<Genre>
    val yearHomeItem: String?
}