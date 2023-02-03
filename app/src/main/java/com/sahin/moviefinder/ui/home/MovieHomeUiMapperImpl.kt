package com.sahin.moviefinder.ui.home

import com.sahin.moviefinder.domain.MovieEntity
import com.sahin.moviefinder.domain.MovieListMapper
import javax.inject.Inject

class MovieHomeUiMapperImpl @Inject constructor() : MovieListMapper<MovieEntity, HomeUiData> {
    override fun map(input: List<MovieEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(
                it.imdbID, it.title, it.year, it.type, it.poster
            )
        } ?: emptyList()
    }
}