package com.sahin.moviefinder.domain

import com.sahin.moviefinder.data.dto.MovieDetailResponse
import javax.inject.Inject

class MovieDomainMapperImpl @Inject constructor() : MovieMapper<MovieDetailResponse, MovieDetailEntity> {
    override fun map(input: MovieDetailResponse?): MovieDetailEntity{
        return input?.let {
            MovieDetailEntity(
                 actors = it.actors,
                 awards = it.awards,
                 boxOffice = it.boxOffice,
                 country = it.country,
                 dVD = it.dVD,
                 director = it.director,
                 genre = it.genre,
                 imdbID = it.imdbID,
                 imdbRating = it.imdbRating,
                 imdbVotes = it.imdbVotes,
                 language = it.language,
                 metascore = it.metascore,
                 plot = it.plot,
                 poster = it.poster,
                 production = it.production,
                 rated = it.rated,
                 ratings = it.ratings,
                 released = it.released,
                 response = it.response,
                 runtime = it.runtime,
                 title = it.title,
                 type = it.type,
                 website = it.website,
                 writer = it.writer,
                 year = it.year
            )
        }?: MovieDetailEntity("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", emptyList(), "", "", "", "", "", "", "", "")
    }
}