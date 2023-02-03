package com.sahin.moviefinder.domain

interface MovieListMapper<I, O> : MovieMapper<List<I>, List<O>>

interface MovieMapper<I, O> {
    fun map(input: I?): O
}