package br.com.tairoroberto.helloworldkotlin.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.tairoroberto.helloworldkotlin.databinding.MovieItemBinding
import br.com.tairoroberto.helloworldkotlin.home.models.Movie
import com.squareup.picasso.Picasso

class RecyclerViewMovieAdapter(private var list: MutableList<Movie>) :
    RecyclerView.Adapter<RecyclerViewMovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val movie = list[position]
            binding.textViewTitle.text = movie.title
            binding.textViewDescription.text = movie.overview
            Picasso.get().load("http://image.tmdb.org/t/p/w500/${movie.posterPath}")
                .into(binding.imageView)
        }
    }

    override fun getItemCount(): Int = list.size


    fun update(newList: MutableList<Movie>?) {
        newList?.let {
            if (list.size == 0) {
                list = newList
            } else {
                list.addAll(newList)
            }
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)
}