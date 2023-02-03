package com.sahin.moviefinder.domain

data class MovieEntity(
    val imdbID: String,
    val title: String,
    val year: String,
    val type: String,
    val poster: String,
)