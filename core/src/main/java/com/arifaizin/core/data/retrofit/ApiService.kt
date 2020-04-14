package com.arifaizin.core.data.retrofit

import com.arifaizin.core.BuildConfig
import com.arifaizin.core.data.model.movie.MovieResponse
import com.arifaizin.core.data.model.tvshow.TvShowResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie?api_key=${BuildConfig.API_KEY}")
    fun getMovieAsync(
        @Query("page") page: Int
    ): Deferred<MovieResponse>

    @GET("discover/tv?api_key=${BuildConfig.API_KEY}")
    fun getTvShowAsync(): Deferred<TvShowResponse>
}