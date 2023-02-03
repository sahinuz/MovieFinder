package com.sahin.moviefinder.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahin.moviefinder.R
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.domain.GetMovieWithIdUseCase
import com.sahin.moviefinder.domain.MovieDetailEntity
import com.sahin.moviefinder.domain.MovieMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieWithIdUseCase: GetMovieWithIdUseCase,
    private val movieMapper: MovieMapper<MovieDetailEntity, DetailUiData>
) :
    ViewModel() {

    private val _movieDetailUiState = MutableLiveData<DetailUiState>()
    val movieDetailUiState: LiveData<DetailUiState> get() = _movieDetailUiState

    fun getMovieDetailWithId(id: String) {
        viewModelScope.launch {
            getMovieWithIdUseCase(id).collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _movieDetailUiState.postValue(DetailUiState.Error(R.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _movieDetailUiState.postValue(DetailUiState.Loading)
                    }
                    is NetworkResponseState.Success -> {
                        _movieDetailUiState.postValue(DetailUiState.Success(movieMapper.map(it.result)))
                    }
                }
            }
        }
    }
}