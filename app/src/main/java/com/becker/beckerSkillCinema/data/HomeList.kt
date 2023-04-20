package com.becker.beckerSkillCinema.data

import com.becker.beckerSkillCinema.data.network.networkEntities.HomeItem

data class HomeList(
    val category: CategoriesFilms,
    val filmList: List<HomeItem>
)