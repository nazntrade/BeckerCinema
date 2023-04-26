package com.becker.beckerSkillCinema.data

import com.becker.beckerSkillCinema.data.models.uiModels.BasicUiMovieModel

data class HomeList(
    val category: CategoriesFilms,
    val filmList: List<BasicUiMovieModel>
)