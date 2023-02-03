package com.sahin.moviefinder.data.repository

import com.sahin.moviefinder.apiException
import com.sahin.moviefinder.movieList
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.data.dto.MovieDetailResponse

class FakeRepository : MovieRepository {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override suspend fun getMoviesWithName(movieName: String): NetworkResponseState<List<Movie>> {
        return if (showError) {
            NetworkResponseState.Error(apiException)
        } else {
            NetworkResponseState.Success(movieList)
        }
    }

    override suspend fun getMoviesWithId(id: String): NetworkResponseState<MovieDetailResponse> {
        TODO("Not yet implemented")
    }

}