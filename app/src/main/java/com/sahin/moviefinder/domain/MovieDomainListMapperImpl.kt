package com.sahin.moviefinder.domain

import com.sahin.moviefinder.data.dto.Movie
import javax.inject.Inject

class MovieDomainListMapperImpl @Inject constructor() : MovieListMapper<Movie, MovieEntity> {
    override fun map(input: List<Movie>?): List<MovieEntity> {
        return input?.map {
            MovieEntity(
                imdbID = it.imdbID,
                title = it.title ,
                year = it.year,
                type = it.type,
                poster = it.poster
            )
        } ?: emptyList()
    }
}