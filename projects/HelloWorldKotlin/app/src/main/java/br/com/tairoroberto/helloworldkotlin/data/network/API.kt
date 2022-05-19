package br.com.tairoroberto.helloworldkotlin.data.network

import br.com.tairoroberto.helloworldkotlin.data.network.RetrofitService.Companion.API_KEY
import br.com.tairoroberto.helloworldkotlin.home.models.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String? = API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("origin") origin: String?
    ): MoviesResponse
}