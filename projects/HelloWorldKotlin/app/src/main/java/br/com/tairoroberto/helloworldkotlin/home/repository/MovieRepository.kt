package br.com.tairoroberto.helloworldkotlin.home.repository

import br.com.tairoroberto.helloworldkotlin.data.network.RetrofitService
import br.com.tairoroberto.helloworldkotlin.home.models.MoviesResponse

class MovieRepository {
    suspend fun getMovieFromNetwork(
        category: String?,
        language: String?,
        page: Int?,
        country: String?
    ): MoviesResponse {

        return RetrofitService.apiService.getMovies(
            category = category,
            language = language,
            page = page,
            origin = country
        )
    }

    /*suspend fun getMovieFromLocal(
        category: String?,
        language: String?,
        page: Int?,
        country: String?
    ): MoviesResponse {

    }*/
}