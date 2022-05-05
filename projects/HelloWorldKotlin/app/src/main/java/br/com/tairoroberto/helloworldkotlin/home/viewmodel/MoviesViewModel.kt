package br.com.tairoroberto.helloworldkotlin.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tairoroberto.helloworldkotlin.home.models.MoviesResponse
import br.com.tairoroberto.helloworldkotlin.home.repository.MovieRepository

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository()

    private var _response: MutableLiveData<MoviesResponse> = MutableLiveData()
    var response: LiveData<MoviesResponse> = _response


    fun getMovies(){
        _response.value = null
    }
}