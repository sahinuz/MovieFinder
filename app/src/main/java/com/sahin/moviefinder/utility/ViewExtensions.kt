package com.sahin.moviefinder.utility

import androidx.appcompat.widget.AppCompatImageView
import coil.load
import coil.size.Scale

fun AppCompatImageView.loadImage(imageUrl: String) {
    load(imageUrl) {
        scale(Scale.FILL)
    }
}