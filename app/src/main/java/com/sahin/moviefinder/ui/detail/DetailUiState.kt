package com.sahin.moviefinder.ui.detail

import androidx.annotation.StringRes

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val data: DetailUiData) : DetailUiState()
    data class Error(@StringRes val message: Int) : DetailUiState()
}