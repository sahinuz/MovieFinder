package com.sahin.moviefinder.di

import com.sahin.moviefinder.domain.GetMovieWithNameUseCase
import com.sahin.moviefinder.domain.GetMovieWithNameUseCaseImpl
import com.sahin.moviefinder.domain.GetMovieWithIdUseCase
import com.sahin.moviefinder.domain.GetMovieWithIdUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)

abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetMovieUseCase(movieWithNameCaseImpl: GetMovieWithNameUseCaseImpl): GetMovieWithNameUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetMovieIdUseCase(movieWithIdUseCaseImpl: GetMovieWithIdUseCaseImpl): GetMovieWithIdUseCase
}