package com.sahin.moviefinder.data.api

import com.sahin.moviefinder.data.dto.MovieDetailResponse
import com.sahin.moviefinder.data.dto.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("./")
    suspend fun getMoviesWithName(@Query("apikey") apiKey: String, @Query("s") movieQuery: String): MovieSearchResponse

    @GET("./")
    suspend fun getMoviesWithId(@Query("apikey") apiKey: String, @Query("i") id: String): MovieDetailResponse
}