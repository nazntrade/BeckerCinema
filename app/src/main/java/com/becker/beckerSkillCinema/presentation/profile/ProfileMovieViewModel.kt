package com.becker.beckerSkillCinema.presentation.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.becker.beckerSkillCinema.data.Collections
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.CustomCollection
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Favorites
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Interesting
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Movie
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.ToWatch
import com.becker.beckerSkillCinema.data.local.dataBaseEntities.Watched
import com.becker.beckerSkillCinema.data.network.networkEntities.filmById.ResponseCurrentFilm
import com.becker.beckerSkillCinema.domain.local.AddMovieToCustomCollectionUseCase
import com.becker.beckerSkillCinema.domain.local.AddMovieToDataBaseUseCase
import com.becker.beckerSkillCinema.domain.local.AddMovieToInterestingUseCase
import com.becker.beckerSkillCinema.domain.local.AddToFavoritesUseCase
import com.becker.beckerSkillCinema.domain.local.AddToWatchUseCase
import com.becker.beckerSkillCinema.domain.local.AddToWatchedUseCase
import com.becker.beckerSkillCinema.domain.local.ClearInterestingUseCase
import com.becker.beckerSkillCinema.domain.local.ClearWatchedUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteCustomCollectionUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteFromFavoritesUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteFromToWatchUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteFromWatchedUseCase
import com.becker.beckerSkillCinema.domain.local.DeleteMovieFromCustomCollectionUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllFavoritesUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllInterestingMoviesUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllLocalMoviesUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllMoviesFromCustomCollectionUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllToWatchUseCase
import com.becker.beckerSkillCinema.domain.local.GetAllWatchedUseCase
import com.becker.beckerSkillCinema.domain.local.GetMovieFromDataBaseByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ProfileMovieViewModel @Inject constructor(
    private val deleteFromToWatchUseCase: DeleteFromToWatchUseCase,
    private val addToWatchUseCase: AddToWatchUseCase,
    private val getAllToWatchUseCase: GetAllToWatchUseCase,
    private val deleteFromFavoritesUseCase: DeleteFromFavoritesUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
    private val clearWatchedUseCase: ClearWatchedUseCase,
    private val deleteFromWatchedUseCase: DeleteFromWatchedUseCase,
    private val getMovieFromDataBaseByIdUseCase: GetMovieFromDataBaseByIdUseCase,
    private val getAllWatchedUseCase: GetAllWatchedUseCase,
    private val getAllMoviesFromCustomCollectionUseCase: GetAllMoviesFromCustomCollectionUseCase,
    private val getAllLocalMoviesUseCase: GetAllLocalMoviesUseCase,
    private val getAllInterestingMoviesUseCase: GetAllInterestingMoviesUseCase,
    private val deleteMovieFromCustomCollectionUseCase: DeleteMovieFromCustomCollectionUseCase,
    private val addMovieToCustomCollectionUseCase: AddMovieToCustomCollectionUseCase,
    private val addMovieToDataBaseUseCase: AddMovieToDataBaseUseCase,
    private val addMovieToInterestingUseCase: AddMovieToInterestingUseCase,
    private val addToWatchedUseCase: AddToWatchedUseCase,
    private val clearInterestingUseCase: ClearInterestingUseCase,
    private val deleteCustomCollectionUseCase: DeleteCustomCollectionUseCase,
    app: Application
) : AndroidViewModel(app) {

    private val _movieSelected = MutableStateFlow(0)
    val movieSelected = _movieSelected.asStateFlow()

    private val _movieInfo = MutableStateFlow<ResponseCurrentFilm?>(null)
    val movieInfo = _movieInfo.asStateFlow()

    private val _addedToFavorites = MutableStateFlow(false)
    val addedToFavorites = _addedToFavorites.asStateFlow()

    private val _addedToWatch = MutableStateFlow(false)
    val addedToWatch = _addedToWatch.asStateFlow()

    private val _addedToWatched = MutableStateFlow(false)
    val addedToWatched = _addedToWatched.asStateFlow()

    private val _movieById = MutableStateFlow<Movie?>(null)
    val movieById = _movieById.asStateFlow()

    private val _addedToCustomCollection = MutableStateFlow(emptyMap<String, Boolean>())
    val addedToCustomCollection = _addedToCustomCollection.asStateFlow()

    private val _customCollectionNamesList = MutableStateFlow<List<String>>(emptyList())
    val customCollectionNamesList = _customCollectionNamesList

    private val _interestingList = MutableStateFlow<List<Movie>>(emptyList())
    val interestingList = _interestingList.asStateFlow()

    private val _watchedList = MutableStateFlow<List<Movie>>(emptyList())
    val watchedList = _watchedList.asStateFlow()

    private val _favoritesList = MutableStateFlow<List<Movie>>(emptyList())
    val favoritesList = _favoritesList.asStateFlow()

    private val _toWatchList = MutableStateFlow<List<Movie>>(emptyList())
    val toWatchList = _toWatchList.asStateFlow()

    private val _customCollectionList = MutableStateFlow<List<Movie>>(emptyList())
    val customCollectionList = _customCollectionList.asStateFlow()

    private val _chosenCollection = MutableStateFlow<Collections>(Collections.Favorites)
    val chosenCollection = _chosenCollection.asStateFlow()

    private val _customCollectionChosen = MutableStateFlow<CustomCollection?>(null)
    val customCollectionChosen = _customCollectionChosen.asStateFlow()

    private val _customCollections = MutableStateFlow<List<CustomCollection>>(emptyList())
    val customCollections = _customCollections.asStateFlow()

    fun getAllInteresting() = getAllInterestingMoviesUseCase.execute()

    private suspend fun addMovieToInteresting(movieId: Int) {
        addMovieToInterestingUseCase.execute(
            interesting = Interesting(
                interestingId = movieId,
                dateAdded = getDateTime()
            )
        )
    }

    private suspend fun deleteAllMoviesFromInteresting() {
        clearInterestingUseCase.execute()
    }

    fun addCurrentFilmToHistory(movieId: Int) {
        viewModelScope.launch {
            try {
                addMovieToInteresting(movieId)
            } catch (e: Throwable) {
                Timber.e("addCurrentFilmToHistory $e")
            }
        }
    }

    fun onClearInteresting() {
        viewModelScope.launch {
            try {
                deleteAllMoviesFromInteresting()
            } catch (e: Throwable) {
                Timber.e("onClearInterestingClick $e")
            }
        }
    }

    fun buildInterestingList(allInteresting: List<Interesting>) {
        viewModelScope.launch {
            try {
                val interestingList = mutableListOf<Movie>()
                allInteresting.forEach { item ->
                    val interestingMovie =
                        getMovieFromDataBaseByIdUseCase.execute(item.interestingId)
                    interestingList.add(interestingMovie)
                }
                _interestingList.value = interestingList
            } catch (e: Throwable) {
                Timber.e("buildInterestingList $e")
            }
        }
    }

    fun getAllMoviesFromCustomCollection() =
        getAllMoviesFromCustomCollectionUseCase.execute()

    suspend fun addMovieToCustomCollection(collectionName: String, movieId: Int) {
        addMovieToCustomCollectionUseCase.execute(
            customCollection = CustomCollection(
                collectionName = collectionName,
                movieId = movieId,
                dateAdded = getDateTime()
            )
        )
    }

    private suspend fun deleteMovieFromCustomCollection(collectionName: String, movieId: Int) {
        deleteMovieFromCustomCollectionUseCase
            .execute(collectionName, movieId)
    }

    private suspend fun deleteCustomCollection(collectionName: String) {
        deleteCustomCollectionUseCase.execute(collectionName)
    }

    fun deleteCollection(collectionName: String) {
        viewModelScope.launch {
            try {
                deleteCustomCollection(collectionName = collectionName)
            } catch (e: Throwable) {
                Timber.e("onDeleteCollectionButtonClick $e")
            }
        }
    }

    fun getCustomCollectionNames(allMovies: List<CustomCollection>) {
        viewModelScope.launch {
            try {
                val collectionsNames = mutableListOf<String>()
                allMovies.forEach {
                    collectionsNames.add(it.collectionName)
                }
                _customCollectionNamesList.value = collectionsNames
            } catch (e: Throwable) {
                Timber.e("getCustomCollectionNames $e")
            }
        }
    }

    fun buildCustomCollectionList(allMovies: List<CustomCollection>) {
        viewModelScope.launch {
            try {
                val customCollectionList = mutableListOf<Movie>()
                _customCollectionChosen.collectLatest { customCollection ->
                    if (customCollection != null) {
                        val filteredList =
                            allMovies.filter { it.collectionName == customCollection.collectionName }
                        filteredList.forEach { item ->
                            if (item.movieId != 0) {
                                val customCollectionMovie =
                                    getMovieFromDataBaseByIdUseCase
                                        .execute(item.movieId)
                                customCollectionList.add(customCollectionMovie)
                            }
                        }
                    }
                    _customCollectionList.value = customCollectionList
                }
            } catch (e: Throwable) {
                Timber.e("buildCustomCollectionList $e")
            }
        }
    }

    fun getCustomCollections(allMovies: List<CustomCollection>) {
        val date = getDateTime()
        viewModelScope.launch {
            try {
                val filteredCollections = mutableListOf<CustomCollection>()
                val collectionsNames = allMovies.groupBy { it.collectionName }
                collectionsNames.forEach { (collectionName, list) ->
                    if (list.contains(CustomCollection(collectionName, 0, date))) {
                        //1.0 instead of id I store here the size of the list
                        filteredCollections
                            .add(CustomCollection(collectionName, list.size - 1, date))
                    } else {
                        //1.0 instead of id I store here the size of the list
                        filteredCollections
                            .add(CustomCollection(collectionName, list.size, date))
                    }
                }
                //1.0 the _customCollections.value stored list.size instead id
                _customCollections.value = filteredCollections
            } catch (e: Throwable) {
                Timber.e("getCustomCollections $e")
            }
        }
    }

    fun onCustomCollectionClick(customCollection: CustomCollection) {
        viewModelScope.launch {
            try {
                _customCollectionChosen.value = customCollection
            } catch (e: Throwable) {
                Timber.e("onCustomCollectionClick $e")
            }
        }
    }

    fun checkCustomCollection(
        collectionName: String,
        movieId: Int,
        index: Int,
        collectionsCount: Int,
        allMovies: List<CustomCollection>
    ) {
        viewModelScope.launch {
            try {
                val customCollectionChosen =
                    allMovies.filter { it.collectionName == collectionName }
                if (index <= (collectionsCount - 1)) {
                    val initialStatus = _addedToCustomCollection.value.entries
                    val status = mutableMapOf<String, Boolean>()
                    initialStatus.forEach { status[it.key] = it.value }
                    status[collectionName] = !customCollectionChosen.all { it.movieId != movieId }
                    _addedToCustomCollection.value = status
                }
            } catch (e: Throwable) {
                Timber.e("checkCustomCollection $e")
            }
        }
    }

    fun onCustomCollectionButtonClick(collectionName: String, movieId: Int) {
        viewModelScope.launch {
            try {
                // add or delete movie to or from custom collection
                if (_addedToCustomCollection.value[collectionName] == false) {
                    val initialStatus = _addedToCustomCollection.value.entries
                    val status = mutableMapOf<String, Boolean>()
                    initialStatus.forEach { status[it.key] = it.value }
                    status[collectionName] = true
                    _addedToCustomCollection.value = status
                    addMovieToCustomCollection(collectionName, movieId)
                } else {
                    val initialStatus = _addedToCustomCollection.value.entries
                    val status = mutableMapOf<String, Boolean>()
                    initialStatus.forEach { status[it.key] = it.value }
                    status[collectionName] = false
                    _addedToCustomCollection.value = status
                    deleteMovieFromCustomCollection(collectionName, movieId)
                }
            } catch (e: Throwable) {
                Timber.e("onCustomCollectionButtonClick $e")
            }
        }
    }

    fun getCurrentMovieFromDataBaseById(movieId: Int) {
        viewModelScope.launch {
            try {
                _movieById.value = getMovieFromDataBaseByIdUseCase.execute(movieId)
            } catch (e: Throwable) {
                Timber.e("getMovieFromDataBaseById $e")
            }
        }
    }

    fun addMovieToDataBase(movie: ResponseCurrentFilm) {
        viewModelScope.launch {
            try {
                addMovieToDataBaseUseCase.execute(
                    movie = Movie(
                        movieId = movie.kinopoiskId,
                        posterUri = movie.posterUrl,
                        rating = movie.ratingKinopoisk ?: movie.ratingImdb
                        ?: movie.ratingFilmCritics ?: movie.ratingRfCritics,
                        genre = movie.genres.firstOrNull()?.genre,
                        movieName = movie.nameRu ?: movie.nameEn ?: movie.nameOriginal,
                        country = movie.countries.firstOrNull()?.country,
                        logoUrl = movie.logoUrl,
                        description = movie.description,
                        shortDescription = movie.shortDescription,
                        filmLength = movie.filmLength,
                        imdbId = movie.imdbId,
                        nameEn = movie.nameEn ?: movie.nameOriginal,
                        ratingAgeLimits = movie.ratingAgeLimits,
                        serial = movie.serial,
                        shortFilm = movie.shortFilm,
                        year = movie.year
                    )
                )
            } catch (e: Throwable) {
                Timber.e("addMovieToDataBase $e")
            }
        }
    }

    fun getAllWatched() = getAllWatchedUseCase.execute()

    private suspend fun addToWatched(movieId: Int) {
        viewModelScope.launch {
            try {
                addToWatchedUseCase.execute(
                    watched = Watched(
                        watchedId = movieId,
                        dateAdded = getDateTime()
                    )
                )
            } catch (e: Throwable) {
                Timber.e("addToWatched $e")
            }
        }
    }

    private suspend fun deleteFromWatched(movieId: Int) {
        viewModelScope.launch {
            try {
                deleteFromWatchedUseCase.execute(movieId)
            } catch (e: Throwable) {
                Timber.e("deleteFromWatched $e")
            }
        }
    }

    fun checkWatched(movieId: Int, allWatched: List<Watched>) {
        viewModelScope.launch {
            try {
                _addedToWatched.value = !allWatched.all { it.watchedId != movieId }
            } catch (e: Throwable) {
                Timber.e("checkWatched $e")
            }
        }
    }

    fun onWatchedButtonClick(movieId: Int) {
        viewModelScope.launch {
            try {
                if (!_addedToWatched.value) {
                    addToWatched(movieId)
                    _addedToWatched.value = true
                    _addedToWatch.value = false
                    deleteFromToWatch(movieId)
                } else {
                    deleteFromWatched(movieId)
                    _addedToWatched.value = false
                }
            } catch (e: Throwable) {
                Timber.e("onWatchedButtonClick $e")
            }
        }
    }

    fun buildWatchedList(allWatched: List<Watched>) {
        viewModelScope.launch {
            try {
                val watchedList = mutableListOf<Movie>()
                allWatched.forEach { item ->
                    val watchedMovie =
                        getMovieFromDataBaseByIdUseCase.execute(item.watchedId)
                    watchedList.add(watchedMovie)
                }
                _watchedList.value = watchedList
            } catch (e: Throwable) {
                Timber.e("buildWatchedList $e")
            }
        }
    }

    private suspend fun deleteAllMoviesFromWatched() {
        clearWatchedUseCase.execute()
    }

    fun onClearWatched() {
        viewModelScope.launch {
            try {
                deleteAllMoviesFromWatched()
            } catch (e: Throwable) {
                Timber.e("onClearWatchedClick $e")
            }
        }
    }

    fun getAllFavorites() = getAllFavoritesUseCase.execute()

    fun getAllMovieFromDataBase() = getAllLocalMoviesUseCase.execute()

    private suspend fun addToFavorites(movieId: Int) {
        viewModelScope.launch {
            try {
                addToFavoritesUseCase.execute(
                    favorites = Favorites(
                        favoritesId = movieId,
                        dateAdded = getDateTime()
                    )
                )
            } catch (e: Throwable) {
                Timber.e("addToFavorites $e")
            }
        }
    }

    private suspend fun deleteFromFavorites(movieId: Int) {
        viewModelScope.launch {
            try {
                deleteFromFavoritesUseCase.execute(movieId)
            } catch (e: Throwable) {
                Timber.e("deleteFromFavorites $e")
            }
        }
    }

    fun checkFavorites(movieId: Int, allFavorites: List<Favorites>) {
        viewModelScope.launch {
            try {
                _addedToFavorites.value = !allFavorites.all { it.favoritesId != movieId }
            } catch (e: Throwable) {
                Timber.e("checkFavorites $e")
            }
        }
    }

    fun onFavoritesButtonClick(movieId: Int) {
        viewModelScope.launch {
            try {
                if (!_addedToFavorites.value) {
                    addToFavorites(movieId)
                    _addedToFavorites.value = true
                } else {
                    deleteFromFavorites(movieId)
                    _addedToFavorites.value = false
                }
            } catch (e: Throwable) {
                Timber.e("onFavoritesButtonClick $e")
            }
        }
    }

    fun buildFavoritesList(allFavorites: List<Favorites>) {
        viewModelScope.launch {
            try {
                val favoritesList = mutableListOf<Movie>()
                allFavorites.forEach { item ->
                    val favoriteMovie =
                        getMovieFromDataBaseByIdUseCase.execute(item.favoritesId)
                    favoritesList.add(favoriteMovie)
                }
                _favoritesList.value = favoritesList
            } catch (e: Throwable) {
                Timber.e("buildFavoritesList $e")
            }
        }
    }

    fun getAllToWatch() = getAllToWatchUseCase.execute()

    private suspend fun addToWatch(movieId: Int) {
        viewModelScope.launch {
            try {
                addToWatchUseCase.execute(
                    toWatch = ToWatch(
                        toWatchId = movieId,
                        dateAdded = getDateTime()
                    )
                )
            } catch (e: Throwable) {
                Timber.e("addToWatch $e")
            }
        }
    }

    private suspend fun deleteFromToWatch(movieId: Int) {
        viewModelScope.launch {
            try {
                deleteFromToWatchUseCase.execute(movieId)
            } catch (e: Throwable) {
                Timber.e("deleteFromToWatch $e")
            }
        }
    }

    fun checkToWatch(movieId: Int, allToWatch: List<ToWatch>) {
        viewModelScope.launch {
            try {
                _addedToWatch.value = !allToWatch.all { it.toWatchId != movieId }
            } catch (e: Throwable) {
                Timber.e("checkToWatch $e")
            }
        }
    }

    fun doOnBookmarkBtnClick(movieId: Int) {
        viewModelScope.launch {
            try {
                if (!_addedToWatch.value) {
                    addToWatch(movieId)
                    _addedToWatch.value = true
                } else {
                    deleteFromToWatch(movieId)
                    _addedToWatch.value = false
                }
            } catch (e: Throwable) {
                Timber.e("doOnBookmarkBtnClick $e")
            }
        }
    }

    fun buildToWatchList(allToWatch: List<ToWatch>) {
        viewModelScope.launch {
            try {
                val toWatchList = mutableListOf<Movie>()
                allToWatch.forEach { item ->
                    val toWatchMovie =
                        getMovieFromDataBaseByIdUseCase.execute(item.toWatchId)
                    toWatchList.add(toWatchMovie)
                }
                _toWatchList.value = toWatchList
            } catch (e: Throwable) {
                Timber.e("buildToWatchList $e")
            }
        }
    }

    fun chooseCollection(chosenCollections: Collections) {
        viewModelScope.launch {
            try {
                _chosenCollection.value = chosenCollections
            } catch (e: Throwable) {
                Timber.e("chosenCollection $e")
            }
        }
    }

    fun movieSelected(itemId: Int) {
        viewModelScope.launch {
            try {
                _movieSelected.value = itemId
            } catch (e: Throwable) {
                Timber.e("movieSelected $e")
            }
        }
    }

    private fun getDateTime(): String {
        val watchedDate = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(watchedDate).toString()
    }

    companion object {
        const val DATE_FORMAT = "yyyy/MM/dd HH:mm:ss"
    }
}