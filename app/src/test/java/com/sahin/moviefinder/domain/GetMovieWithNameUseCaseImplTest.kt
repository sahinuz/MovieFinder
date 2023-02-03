package com.sahin.moviefinder.domain

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.data.repository.FakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMovieWithNameUseCaseImplTest {

    private val fakeRepository = FakeRepository()

    private val movieDomainListMapperImpl = MovieDomainListMapperImpl()

    private lateinit var  getMovieWithNameUseCaseImpl: GetMovieWithNameUseCaseImpl

    @Before
    fun setup() {
        getMovieWithNameUseCaseImpl =
            GetMovieWithNameUseCaseImpl(fakeRepository, movieDomainListMapperImpl)
    }

    @Test
    fun when_searchQueryMatrix_isFirstState_Downloading() {
        runBlocking {
            getMovieWithNameUseCaseImpl("The Matrix").test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun when_repositoryResponseFailure_is_state_downloading_and_failure_sequentially() {
        fakeRepository.updateShowError(true)
        runBlocking {
            getMovieWithNameUseCaseImpl("The Matrix").test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun when_repositoryResponseSuccess_is_state_downloading_and_success_sequentially() {
        runBlocking {
            getMovieWithNameUseCaseImpl("The Matrix").test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }
        }
    }
}