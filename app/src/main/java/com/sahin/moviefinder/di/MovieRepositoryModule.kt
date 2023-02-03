package com.sahin.moviefinder.di

import com.sahin.moviefinder.data.repository.MovieRepository
import com.sahin.moviefinder.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieRepositoryModule {


    @Binds
    @ViewModelScoped
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}