package com.sahin.moviefinder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sahin.moviefinder.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel by viewModels<HomeViewModel>()

    private val adapter by lazy { MovieRecyclerViewAdapter(::itemOnClickListener) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater).apply {
            movieListRecyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            viewModel.getMovieWithName(binding.searchEditText.text.toString())
        }
        observeUiState()
    }

    private fun observeUiState() {
        viewModel.movieHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_LONG)
                        .show()
                }
                HomeUiState.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                }
                is HomeUiState.Success -> {
                    handleSuccessUiState(it.data)
                }
            }
        }
    }

    private fun handleSuccessUiState(data: List<HomeUiData>) {
        adapter.updateItems(data)
    }

    private fun itemOnClickListener(id: String){
        var action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        findNavController().navigate(action)
    }
}