package com.sahin.moviefinder.domain

import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.data.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieWithNameUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieListMapper: MovieListMapper<Movie, MovieEntity>
) :
    GetMovieWithNameUseCase {

    override operator fun invoke(movieName: String): Flow<NetworkResponseState<List<MovieEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when (val response = movieRepository.getMoviesWithName(movieName)) {
                is NetworkResponseState.Error -> emit(response)
                NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(
                        movieListMapper.map(
                            response.result
                        )
                    )
                )
            }
        }
}