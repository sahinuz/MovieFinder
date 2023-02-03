package com.sahin.moviefinder.di

import com.sahin.moviefinder.data.dto.Movie
import com.sahin.moviefinder.data.dto.MovieDetailResponse
import com.sahin.moviefinder.domain.*
import com.sahin.moviefinder.ui.detail.DetailUiData
import com.sahin.moviefinder.ui.detail.MovieDetailUiMapperImpl
import com.sahin.moviefinder.ui.home.HomeUiData
import com.sahin.moviefinder.ui.home.MovieHomeUiMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieDomainListMapper(movieDomainListMapperImpl: MovieDomainListMapperImpl): MovieListMapper<Movie, MovieEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindMovieDomainMapper(movieDomainMapperImpl: MovieDomainMapperImpl): MovieMapper<MovieDetailResponse, MovieDetailEntity>


    @Binds
    @ViewModelScoped
    abstract fun bindMovieHomeUiMapper(movieHomeUiMapperImpl: MovieHomeUiMapperImpl): MovieListMapper<MovieEntity, HomeUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindMovieDetailUiMapper(movieDetailUiMapperImpl: MovieDetailUiMapperImpl): MovieMapper<MovieDetailEntity, DetailUiData>
}