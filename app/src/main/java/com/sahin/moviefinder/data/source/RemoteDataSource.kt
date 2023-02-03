package com.sahin.moviefinder.data.source

import  com.sahin.moviefinder.data.NetworkResponseState
import  com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.data.dto.MovieDetailResponse

interface RemoteDataSource {
    suspend fun getMoviesWithName(movieName: String): NetworkResponseState<List<Movie>>
    suspend fun getMoviesWithId(id: String): NetworkResponseState<MovieDetailResponse>
}