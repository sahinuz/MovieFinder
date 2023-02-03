package com.sahin.moviefinder.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahin.moviefinder.R
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.domain.GetMovieWithNameUseCase
import com.sahin.moviefinder.domain.MovieEntity
import com.sahin.moviefinder.domain.MovieListMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieWithNameUseCase: GetMovieWithNameUseCase,
    private val movieListMapper: MovieListMapper<MovieEntity, HomeUiData>
) :
    ViewModel() {

    private val _movieHomeUiState = MutableLiveData<HomeUiState>()
    val movieHomeUiState: LiveData<HomeUiState> get() = _movieHomeUiState

    fun getMovieWithName(movieName: String) {
        viewModelScope.launch {
            getMovieWithNameUseCase(movieName).collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _movieHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _movieHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Success -> {
                        _movieHomeUiState.postValue(HomeUiState.Success(movieListMapper.map(it.result)))
                    }
                }
            }
        }
    }
}



