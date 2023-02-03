package com.sahin.moviefinder.data.api

import com.google.common.truth.Truth.assertThat
import com.sahin.moviefinder.SAMPLE_MOVIE_NAME
import com.sahin.moviefinder.SAMPLE_RESPONSE_FILE_NAME
import com.sahin.moviefinder.API_KEY
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiTest {

    private lateinit var api: MovieApi
    private val FORMATTED_SAMPLE_MOVIE_NAME = "The%20Matrix"
    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start(8080)
        api = Retrofit.Builder().baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build().create(MovieApi::class.java)
    }

    @Test
    fun when_searchQueryMatrix_is_response_NotNull() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME)
            val response = api.getMoviesWithName(API_KEY,SAMPLE_MOVIE_NAME)
            val request = mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    @Test
    fun when_searchQueryMatrix_is_requestPath_same() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME)
            val response = api.getMoviesWithName(API_KEY,SAMPLE_MOVIE_NAME)
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/?apikey=$API_KEY&s=$FORMATTED_SAMPLE_MOVIE_NAME")
        }
    }

    @Test
    fun when_searchQueryMatrix_is_firstItemImdbId_expected() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME)
            val response = api.getMoviesWithName(API_KEY,SAMPLE_MOVIE_NAME)
            val firstItem = response.search!!.first()
            assertThat(firstItem.imdbID).isEqualTo("tt0133093")
        }
    }

    private fun enqueueResponse(fileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }
}