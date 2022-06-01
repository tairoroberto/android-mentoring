package br.com.tairoroberto.helloworldkotlin.home.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tairoroberto.helloworldkotlin.databinding.FragmentMovieBinding
import br.com.tairoroberto.helloworldkotlin.home.models.Status
import br.com.tairoroberto.helloworldkotlin.home.viewmodel.MoviesViewModel
import com.google.android.material.snackbar.Snackbar

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    private val viewModel: MoviesViewModel by lazy {
        ViewModelProvider(this)[MoviesViewModel::class.java]
    }

    private var page = 1
    private val totalPages = 10
    private val adapter = RecyclerViewMovieAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovies("top_rated", page)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.response.observe(viewLifecycleOwner) {

            when (it.status) {
                Status.SUCCESS -> {
                    adapter.update(it.data?.movies?.toMutableList())
                }
                Status.LOADING -> {
                    binding.progressBar.isVisible = it.loading == true
                }
                Status.ERROR -> {
                    Snackbar.make(binding.root, "${it.error?.message}", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}