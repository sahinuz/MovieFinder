package com.sahin.moviefinder.ui.home

import com.google.common.truth.Truth.assertThat
import com.sahin.moviefinder.movieEntities
import org.junit.Before
import org.junit.Test

internal class MovieHomeUiMapperImplTest {

    private val movieHomeUiMapperImpl = MovieHomeUiMapperImpl()

    private lateinit var uiElements: List<HomeUiData>

    @Before
    fun setup() {
        uiElements = movieHomeUiMapperImpl.map(movieEntities)
    }

    @Test
    fun when_entity_mapped_is_title_correct() {
        assertThat(uiElements[0].title).isEqualTo(movieEntities[0].title)
    }

    @Test
    fun when_entity_mapped_is_poster_correct() {
        assertThat(uiElements[0].poster).isEqualTo(movieEntities[0].poster)
    }

    @Test
    fun when_entity_mapped_is_size_of_lists_same() {
        assertThat(uiElements.size).isEqualTo(movieEntities.size)
    }

    @Test
    fun when_input_entity_is_null_is_result_empty() {
        val newUiElements = movieHomeUiMapperImpl.map(null)
        assert(newUiElements.isEmpty())
    }
}