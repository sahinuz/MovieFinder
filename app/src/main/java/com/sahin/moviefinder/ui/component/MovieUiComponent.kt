package com.sahin.moviefinder.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.sahin.moviefinder.databinding.LayoutMovieBinding
import com.sahin.moviefinder.ui.home.HomeUiData
import com.sahin.moviefinder.utility.loadImage

class MovieUiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding = LayoutMovieBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setMovieData(homeUiData: HomeUiData) {
        binding.name.text = homeUiData.title
        binding.movieImage.loadImage(homeUiData.poster)
    }
}