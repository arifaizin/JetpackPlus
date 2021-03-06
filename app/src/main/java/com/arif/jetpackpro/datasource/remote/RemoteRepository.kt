package com.arif.jetpackpro.datasource.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import com.arif.jetpackpro.util.EspressoIdlingResource
import com.arif.jetpackpro.retrofit.ApiConfig
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RemoteRepository {
    companion object {
        private var INSTANCE: RemoteRepository? = null

        fun getInstance(): RemoteRepository {
            if (INSTANCE == null) {
                INSTANCE = RemoteRepository()
            }
            return INSTANCE as RemoteRepository
        }
    }

    fun getAllMoviesAsLiveData(page: Int): LiveData<ApiResponse<List<MovieModel>>>{
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieModel>>>()
        GlobalScope.launch {
            try {
                val postsRequest = ApiConfig.getApiService.getMovieAsync(page)
                val postsResponse = postsRequest.await().results
                resultMovie.postValue(ApiResponse.success(postsResponse as List<MovieModel>))
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
            }
        }
        return resultMovie
    }

    fun getAllTvShowAsLiveData(): LiveData<ApiResponse<List<TvShowModel>>>{
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<TvShowModel>>>()
        GlobalScope.launch {
            try {
                val postsRequest = ApiConfig.getApiService.getTvShowAsync()
                val postsResponse = postsRequest.await().results
                resultMovie.postValue(ApiResponse.success(postsResponse as List<TvShowModel>))
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
            }
        }
        return resultMovie
    }
}