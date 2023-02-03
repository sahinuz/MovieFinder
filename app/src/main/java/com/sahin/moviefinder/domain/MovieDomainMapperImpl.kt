package com.sahin.moviefinder.domain

import com.sahin.moviefinder.data.dto.MovieDetailResponse
import javax.inject.Inject

class MovieDomainMapperImpl @Inject constructor() : MovieMapper<MovieDetailResponse, MovieDetailEntity> {
    override fun map(input: MovieDetailResponse?): MovieDetailEntity{
        return MovieDetailEntity(
                 actors = input?.actors.orEmpty(),
                 awards = input?.awards.orEmpty(),
                 boxOffice = input?.boxOffice.orEmpty(),
                 country = input?.country.orEmpty(),
                 dVD = input?.dVD.orEmpty(),
                 director = input?.director.orEmpty(),
                 genre = input?.genre.orEmpty(),
                 imdbID = input?.imdbID.orEmpty(),
                 imdbRating = input?.imdbRating.orEmpty(),
                 imdbVotes = input?.imdbVotes.orEmpty(),
                 language = input?.language.orEmpty(),
                 metascore = input?.metascore.orEmpty(),
                 plot = input?.plot.orEmpty(),
                 poster = input?.poster.orEmpty(),
                 production = input?.production.orEmpty(),
                 rated = input?.rated.orEmpty(),
                 ratings = input?.ratings.orEmpty(),
                 released = input?.released.orEmpty(),
                 response = input?.response.orEmpty(),
                 runtime = input?.runtime.orEmpty(),
                 title = input?.title.orEmpty(),
                 type = input?.type.orEmpty(),
                 website = input?.website.orEmpty(),
                 writer = input?.writer.orEmpty(),
                 year = input?.year.orEmpty()
            )
    }
}