package com.becker.beckerSkillCinema.data

sealed class Collections {
    object Favorites : Collections()
    object ToWatch : Collections()
    object Custom : Collections()
}