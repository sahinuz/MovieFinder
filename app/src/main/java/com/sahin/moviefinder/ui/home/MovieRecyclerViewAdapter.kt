package com.sahin.moviefinder.ui.home

import android.view.ViewGroup
import com.sahin.moviefinder.ui.base.BaseRecyclerViewAdapter

class MovieRecyclerViewAdapter(private val itemOnClickListener: ((String)->Unit)?) : BaseRecyclerViewAdapter<HomeUiData, MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.createFrom(parent,itemOnClickListener)
    }
}

