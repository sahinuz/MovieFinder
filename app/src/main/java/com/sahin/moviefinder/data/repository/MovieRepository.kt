package com.sahin.moviefinder.data.repository

import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.data.dto.MovieDetailResponse

interface MovieRepository {
    suspend fun getMoviesWithName(movieName: String): NetworkResponseState<List<Movie>>
    suspend fun getMoviesWithId(id: String): NetworkResponseState<MovieDetailResponse>
}