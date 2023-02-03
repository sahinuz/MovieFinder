package com.sahin.moviefinder.ui.detail

import com.sahin.moviefinder.domain.MovieDetailEntity
import com.sahin.moviefinder.domain.MovieMapper
import javax.inject.Inject

class MovieDetailUiMapperImpl @Inject constructor() : MovieMapper<MovieDetailEntity, DetailUiData> {
    override fun map(input: MovieDetailEntity?): DetailUiData {
        return input?.let {
            DetailUiData(
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
        } ?: DetailUiData("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", emptyList(), "", "", "", "", "", "", "", "")
    }
}