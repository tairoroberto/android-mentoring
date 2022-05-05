package br.com.tairoroberto.helloworldkotlin.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import br.com.tairoroberto.helloworldkotlin.R
import br.com.tairoroberto.helloworldkotlin.home.viewmodel.MoviesViewModel

class MovieFragment : Fragment() {

    private val viewModel : MoviesViewModel by lazy {
        ViewModelProvider(this)[MoviesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovies()

        viewModel.response.observe(viewLifecycleOwner) {
            // TODO mostrar filmes
        }
    }
}