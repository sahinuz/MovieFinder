package com.sahin.moviefinder.ui.home

import android.view.ViewGroup
import com.sahin.moviefinder.databinding.AdapterMovieItemBinding
import com.sahin.moviefinder.ui.base.BaseViewHolder
import com.sahin.moviefinder.utility.inflateAdapterItem

class MovieViewHolder(private val binding: AdapterMovieItemBinding,
                      private val itemOnClickListener: ((String)->Unit)?
) :
        BaseViewHolder<HomeUiData>(binding.root) {

        companion object {
            fun createFrom(parent: ViewGroup, itemClickListener: ((String)->Unit)?) =
                MovieViewHolder(parent.inflateAdapterItem(AdapterMovieItemBinding::inflate),itemClickListener)
        }

        override fun onBind(data: HomeUiData) {
            binding.movieComponent.setMovieData(data)

            binding.movieComponent.setOnClickListener {
                itemOnClickListener?.invoke(data.imdbID)
            }

        }


    }