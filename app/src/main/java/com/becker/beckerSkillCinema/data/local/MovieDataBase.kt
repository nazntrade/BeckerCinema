package com.becker.beckerSkillCinema.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.becker.beckerSkillCinema.data.local.dao.CustomCollectionDao
import com.becker.beckerSkillCinema.data.local.dao.FavoritesDao
import com.becker.beckerSkillCinema.data.local.dao.InterestingDao
import com.becker.beckerSkillCinema.data.local.dao.MovieDao
import com.becker.beckerSkillCinema.data.local.dao.ToWatchDao
import com.becker.beckerSkillCinema.data.local.dao.WatchedDao
import com.becker.beckerSkillCinema.data.models.localModels.CustomCollection
import com.becker.beckerSkillCinema.data.models.localModels.Favorites
import com.becker.beckerSkillCinema.data.models.localModels.Interesting
import com.becker.beckerSkillCinema.data.models.localModels.Movie
import com.becker.beckerSkillCinema.data.models.localModels.ToWatch
import com.becker.beckerSkillCinema.data.models.localModels.Watched

const val DB_VERSION = 1

@Database(
    entities = [
        Favorites::class,
        ToWatch::class,
        Watched::class,
        Movie::class,
        CustomCollection::class,
        Interesting::class],
    version = DB_VERSION
)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun favoritesDao(): FavoritesDao
    abstract fun toWatchDao(): ToWatchDao
    abstract fun watchedDao(): WatchedDao
    abstract fun customCollectionDao(): CustomCollectionDao
    abstract fun interestingDao(): InterestingDao
}