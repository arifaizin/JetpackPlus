package com.arifaizin.core.data.datasource.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.data.retrofit.ApiConfig
import com.arifaizin.core.di.scope.AppScope
import com.arifaizin.core.util.EspressoIdlingResource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AppScope
class RemoteRepository @Inject constructor() {
//    companion object {
//        private var INSTANCE: RemoteRepository? = null
//
//        fun getInstance(): RemoteRepository {
//            if (INSTANCE == null) {
//                INSTANCE = RemoteRepository()
//            }
//            return INSTANCE as RemoteRepository
//        }
//    }

    fun getAllMoviesAsLiveData(page: Int): LiveData<ApiResponse<List<MovieModel>>>{
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieModel>>>()
        GlobalScope.launch {
            try {
                val postsRequest = ApiConfig.getApiService.getMovieAsync(page)
                val postsResponse = postsRequest.await().results
                resultMovie.postValue(
                    ApiResponse.success(
                        postsResponse as List<MovieModel>
                    )
                )
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
                resultMovie.postValue(
                    ApiResponse.success(
                        postsResponse as List<TvShowModel>
                    )
                )
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
            }
        }
        return resultMovie
    }
}