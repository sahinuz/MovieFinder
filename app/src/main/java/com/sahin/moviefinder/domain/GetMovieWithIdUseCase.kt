package com.sahin.moviefinder.domain

import com.sahin.moviefinder.data.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface GetMovieWithIdUseCase {
    operator fun invoke(id: String): Flow<NetworkResponseState<MovieDetailEntity>>
}