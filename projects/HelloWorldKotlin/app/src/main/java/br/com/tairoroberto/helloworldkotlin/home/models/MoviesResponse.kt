package br.com.tairoroberto.helloworldkotlin.home.models

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("results")
    val movies: List<Movie>?,
    @SerializedName("total_results")
    val totalResults: Int = 0
)