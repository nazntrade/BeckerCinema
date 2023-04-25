package com.becker.beckerSkillCinema.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.becker.beckerSkillCinema.data.local.dao.CustomCollectionDao
import com.becker.beckerSkillCinema.data.local.dao.FavoritesDao
import com.becker.beckerSkillCinema.data.local.dao.InterestingDao
import com.becker.beckerSkillCinema.data.local.dao.MovieDao
import com.becker.beckerSkillCinema.data.local.dao.ToWatchDao
import com.becker.beckerSkillCinema.data.local.dao.WatchedDao
import com.becker.beckerSkillCinema.data.models.dataBaseEntities.CustomCollection
import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Favorites
import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Interesting
import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Movie
import com.becker.beckerSkillCinema.data.models.dataBaseEntities.ToWatch
import com.becker.beckerSkillCinema.data.models.dataBaseEntities.Watched

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