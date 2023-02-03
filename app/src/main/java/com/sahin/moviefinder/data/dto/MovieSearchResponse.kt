package com.sahin.moviefinder.data.dto


import com.google.gson.annotations.SerializedName

data class MovieSearchResponse(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Movie>,
    @SerializedName("totalResults")
    val totalResults: String
)