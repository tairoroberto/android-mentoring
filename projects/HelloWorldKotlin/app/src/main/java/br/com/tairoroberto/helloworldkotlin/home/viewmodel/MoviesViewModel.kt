package br.com.tairoroberto.helloworldkotlin.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.tairoroberto.helloworldkotlin.home.models.MoviesResponse
import br.com.tairoroberto.helloworldkotlin.home.models.State
import br.com.tairoroberto.helloworldkotlin.home.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository()

    private var _response: MutableLiveData<State<MoviesResponse>> = MutableLiveData()
    var response: LiveData<State<MoviesResponse>> = _response


    fun getMovies(category: String, page: Int) {
        _response.value = State.loading(true)
        viewModelScope.launch {
            try {
                val apiResponse = withContext(Dispatchers.IO) {
                    repository.getMovieFromNetwork(category, "pt-BR", page, "BR")
                }
                _response.value = State.success(apiResponse)
            } catch (e: Exception) {
                _response.value = State.error(e)
            } finally {
                _response.value = State.loading(false)
            }
        }
    }
}