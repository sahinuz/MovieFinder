package com.sahin.moviefinder.data.source

import com.google.common.truth.Truth.assertThat
import com.sahin.moviefinder.API_KEY
import com.sahin.moviefinder.MOVIE_QUERY
import com.sahin.moviefinder.SAMPLE_MOVIE_NAME
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.api.MovieApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class RemoteDataSourceImplTest {

    @Mock
    private lateinit var movieApi: MovieApi

    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImpl = RemoteDataSourceImpl(movieApi)
    }

    @Test
    fun when_movieApi_ReturnedNull_is_State_Failure() {
        runBlocking {
            Mockito.`when`(movieApi.getMoviesWithName(API_KEY,MOVIE_QUERY))
                .thenReturn(
                    null
                )

            val response =
                remoteDataSourceImpl.getMoviesWithName(SAMPLE_MOVIE_NAME)
            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }
}