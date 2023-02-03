package com.sahin.moviefinder.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sahin.moviefinder.databinding.FragmentDetailBinding
import com.sahin.moviefinder.utility.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goBack.setOnClickListener {
            goBack()
        }

        arguments?.let{
            val id = DetailFragmentArgs.fromBundle(it).id
            println(id)
            viewModel.getMovieDetailWithId(id.toString())
        }
        observeUiState()
    }

    private fun observeUiState() {
        viewModel.movieDetailUiState.observe(viewLifecycleOwner) {
            when (it) {
                is DetailUiState.Error -> {
                    Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_LONG)
                        .show()
                }
                DetailUiState.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                }
                is DetailUiState.Success -> {
                    binding.movieImage.loadImage(it.data.poster)
                    binding.movieTitle.text = it.data.title
                    binding.movieDirector.text = it.data.director
                    binding.movieYear.text = it.data.year
                    binding.movieGenre.text = it.data.genre
                    binding.movieRating.text = it.data.imdbRating
                    binding.moviePlot.text = it.data.plot
                }
            }
        }
    }

    private fun goBack(){
        var action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
        findNavController().navigate(action)
    }
}