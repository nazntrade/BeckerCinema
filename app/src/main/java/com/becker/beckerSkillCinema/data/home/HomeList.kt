package com.becker.beckerSkillCinema.data.home

import com.becker.beckerSkillCinema.data.CategoriesFilms
import com.becker.beckerSkillCinema.data.entities.HomeItem

data class HomeList(
    val category: CategoriesFilms,
    val filmList: List<HomeItem>
)