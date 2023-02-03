package com.sahin.moviefinder.data.source

import com.sahin.moviefinder.BuildConfig
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.api.MovieApi
import com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.data.dto.MovieDetailResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val movieApi: MovieApi) : RemoteDataSource {
    private val apiKey = BuildConfig.API_KEY
    override suspend fun getMoviesWithName(movieName: String): NetworkResponseState<List<Movie>> =
        try {
            val response = movieApi.getMoviesWithName(
                apiKey,movieName
            )
            NetworkResponseState.Success(response.search)
        } catch (e: Exception) {
            NetworkResponseState.Error(e)
        }

    override suspend fun getMoviesWithId(id: String): NetworkResponseState<MovieDetailResponse> =
        try {
            val response = movieApi.getMoviesWithId(apiKey,id)
            NetworkResponseState.Success(response)
        } catch (e: Exception) {
            NetworkResponseState.Error(e)
        }
}