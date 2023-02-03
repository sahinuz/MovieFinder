package com.sahin.moviefinder.domain

import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.dto.MovieDetailResponse
import com.sahin.moviefinder.data.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieWithIdUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieDetailMapper: MovieMapper<MovieDetailResponse, MovieDetailEntity>
) :
    GetMovieWithIdUseCase {

    override operator fun invoke(id: String): Flow<NetworkResponseState<MovieDetailEntity>> =
        flow {
            emit(NetworkResponseState.Loading)
            when (val response = movieRepository.getMoviesWithId(id)) {
                is NetworkResponseState.Error -> emit(response)
                NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(
                        movieDetailMapper.map(
                            response.result
                        )
                    )
                )
            }
        }
}