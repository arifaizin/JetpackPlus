package com.arif.jetpackpro.retrofit

import com.arif.jetpackpro.BuildConfig
import com.arif.jetpackpro.model.movie.MovieResponse
import com.arif.jetpackpro.model.tvshow.TvShowResponse
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