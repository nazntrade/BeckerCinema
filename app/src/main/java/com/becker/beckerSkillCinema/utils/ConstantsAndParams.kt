package com.becker.beckerSkillCinema.utils

import com.becker.beckerSkillCinema.data.CategoriesFilms
import com.becker.beckerSkillCinema.data.TopTypesForApiQuery

object ConstantsAndParams {

    const val SHARED_PREFS_NAME = "onBoardingFirstRun"
    const val FIRST_RUN = "FirstRun"
    const val KINOPOISKACCESSRIGHT1 = "70e0059c-0587-4549-9cbf-8a9c5c4143f6"
    const val KINOPOISKACCESSRIGHT2 = "2c7d0bf6-864e-4403-a497-85dde3bc1c16"
    const val KINOPOISKACCESSRIGHT3 = "c92f9a94-f068-435f-855b-a5acff019cc5"
    const val KINOPOISKACCESSRIGHT4 = "8c5cddf6-0364-4744-a57b-5d13c7f48063"
    const val KINOPOISKACCESSRIGHT5 = "4afdb41e-920d-4f23-bb5b-ff9015206a1b"
    const val KINOPOISKACCESSRIGHT6 = "ca3b0d40-c9dc-4950-b32f-d4e29e560d62"
    const val KINOPOISKACCESSRIGHT7 = "b317ee48-fb96-4de5-9fd6-eb95d9598322"
    const val KINOPOISKACCESSRIGHT8 = "187344d2-c8a5-43e9-82e5-f574f97cc045"
    const val KINOPOISKACCESSRIGHT9 = "5d6e59d8-d24e-45f8-95c9-b5b07cb478da"
    const val KINOPOISKACCESSRIGHT10 = "b9ebd173-2eb5-4bfd-b6e9-3226369f0a43"
    const val KINOPOISKACCESSRIGHT11 = "00ec3c68-8c85-4bd5-8508-024db2f99a4c"
    const val KINOPOISKACCESSRIGHT12 = "f746dfa5-8093-401b-8df2-e84042f3dc96"
    const val KINOPOISKACCESSRIGHT13 = "ffcd0204-2065-4214-b6ae-aa29f5fe4003"
    const val KINOPOISKACCESSRIGHT14 = "20c3f30c-7ba7-4417-9c72-4975ac6091c6"
    const val KINOPOISKACCESSRIGHT15 = "f8b0f389-e491-48d0-8794-240a6d0bc635"
    const val KINOPOISKACCESSRIGHT16 = "310f1d28-9363-42cf-be67-94a3ea2424ca"
    const val KINOPOISKACCESSRIGHT17 = "130f6e6d-9e90-4c52-8cf5-8c4cda072fa8"

    val TOP_TYPES = mapOf(
        CategoriesFilms.BIOGRAPHY to TopTypesForApiQuery.FILM.name,
        CategoriesFilms.SCIENCE_FICTION to TopTypesForApiQuery.FILM.name,
        CategoriesFilms.CARTOONS to TopTypesForApiQuery.FILM.name,
        CategoriesFilms.BEST_250 to TopTypesForApiQuery.TOP_250_BEST_FILMS.name,
        CategoriesFilms.POPULAR_100 to TopTypesForApiQuery.TOP_100_POPULAR_FILMS.name,
        CategoriesFilms.MOST_AWAIT to TopTypesForApiQuery.TOP_AWAIT_FILMS.name,
        CategoriesFilms.TV_SERIES to TopTypesForApiQuery.TV_SERIES.name
    )
}