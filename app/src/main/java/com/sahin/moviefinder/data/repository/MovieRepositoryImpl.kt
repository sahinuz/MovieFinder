package com.sahin.moviefinder.data.repository

import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.data.dto.MovieDetailResponse
import com.sahin.moviefinder.data.source.RemoteDataSource
import com.sahin.moviefinder.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    MovieRepository {
    override suspend fun getMoviesWithName(movieName:String): NetworkResponseState<List<Movie>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getMoviesWithName(movieName)
            } catch (e: Exception) {
                NetworkResponseState.Error(e)
            }
        }

    override suspend fun getMoviesWithId(id: String): NetworkResponseState<MovieDetailResponse> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getMoviesWithId(id)
            } catch (e: Exception) {
                NetworkResponseState.Error(e)
            }
        }
}