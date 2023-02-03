package com.sahin.moviefinder
import androidx.annotation.VisibleForTesting
import com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.domain.MovieEntity
import com.sahin.moviefinder.ui.home.HomeUiData

const val SAMPLE_MOVIE_NAME = "The Matrix"
const val SAMPLE_RESPONSE_FILE_NAME = "MovieResponse.json"
const val apiKey = BuildConfig.API_KEY
const val API_KEY = apiKey
const val MOVIE_QUERY = SAMPLE_MOVIE_NAME

@VisibleForTesting
val movieDto = Movie(
    "tt0133093",
    "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
    "The Matrix",
    "movie",
    "1999"
)


@VisibleForTesting
val movieList = mutableListOf(movieDto)

val movieEntity = MovieEntity(
    "tt0133093",
    "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
    "The Matrix",
    "movie",
    "1999"
)

val movieEntities = mutableListOf(movieEntity)

val movieUiData = HomeUiData(
    "tt0133093",
    "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
    "The Matrix",
    "movie",
    "1999"
)

val homeUiDataList = mutableListOf(movieUiData)

val apiException = Exception("Something went wrong")