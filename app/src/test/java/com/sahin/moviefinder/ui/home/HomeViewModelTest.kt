package com.sahin.moviefinder.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.sahin.moviefinder.SAMPLE_MOVIE_NAME
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.domain.FakeGetMovieWithNameUseCase
import com.sahin.moviefinder.homeUiDataList
import com.sahin.moviefinder.movieEntities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

class HomeViewModelTest {

    @Mock
    private lateinit var getMovieWithNameUseCase: FakeGetMovieWithNameUseCase

    private val movieHomeUiMapperImpl = MovieHomeUiMapperImpl()

    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var observer: Observer<HomeUiState>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = HomeViewModel(getMovieWithNameUseCase, movieHomeUiMapperImpl)
        viewModel.movieHomeUiState.observeForever(observer)
    }

    @Test
    fun when_useCaseReturnedDownloading_is_live_data_state_downloading() {
        runBlocking {
            Mockito.`when`(getMovieWithNameUseCase.invoke(SAMPLE_MOVIE_NAME))
                .thenReturn(flow {
                    emit(NetworkResponseState.Loading)
                    emit(NetworkResponseState.Success(movieEntities))
                })

            viewModel.getMovieWithName(SAMPLE_MOVIE_NAME)

            verify(observer).onChanged(HomeUiState.Loading)
            verify(observer).onChanged(HomeUiState.Success(homeUiDataList))
        }
    }


    @After
    fun shutdown() {
        Dispatchers.resetMain()
        viewModel.movieHomeUiState.removeObserver(observer)
    }
}