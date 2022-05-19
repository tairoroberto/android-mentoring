package br.com.tairoroberto.helloworldkotlin.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.tairoroberto.helloworldkotlin.home.models.MoviesResponse
import br.com.tairoroberto.helloworldkotlin.home.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository()

    private var _response: MutableLiveData<MoviesResponse> = MutableLiveData()
    var response: LiveData<MoviesResponse> = _response

    private var _errorResponse: MutableLiveData<Throwable> = MutableLiveData()
    var errorResponse: LiveData<Throwable> = _errorResponse

    private var _loading: MutableLiveData<Boolean> = MutableLiveData()
    var loading: LiveData<Boolean> = _loading


    fun getMovies(category: String, page: Int) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val apiResponse = withContext(Dispatchers.IO) {
                    repository.getMovieFromNetwork(category, "pt-BR", page, "BR")
                }
                _response.value = apiResponse
            } catch (e: Exception) {
                _errorResponse.value = e
            } finally {
                _loading.value = false
            }
        }
    }
}