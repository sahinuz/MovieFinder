package com.sahin.moviefinder.domain

import com.sahin.moviefinder.data.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface GetMovieWithNameUseCase {

    operator fun invoke(movieName: String): Flow<NetworkResponseState<List<MovieEntity>>>
}