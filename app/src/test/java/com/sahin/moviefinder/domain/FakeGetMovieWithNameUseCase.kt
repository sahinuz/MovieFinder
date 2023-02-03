package com.sahin.moviefinder.domain

import com.sahin.moviefinder.apiException
import com.sahin.moviefinder.data.NetworkResponseState
import com.sahin.moviefinder.movieEntities
import kotlinx.coroutines.flow.flow

class FakeGetMovieWithNameUseCase : GetMovieWithNameUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override fun invoke(movieName: String) = flow {
        emit(NetworkResponseState.Loading)
        if (showError) {
            emit(NetworkResponseState.Error(apiException))
        } else {
            emit(NetworkResponseState.Success(movieEntities))
        }
    }
}