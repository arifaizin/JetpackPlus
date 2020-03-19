package com.arif.jetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arif.jetpackpro.datasource.MovieRepository


class ViewModelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(movieRepository) as T
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(movieRepository) as T
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(movieRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

//    companion object {
//        @Volatile
//        private var INSTANCE: ViewModelFactory? = null
//
//        fun getInstance(application: Application): ViewModelFactory? {
//            if (INSTANCE == null) {
//                synchronized(ViewModelFactory::class.java) {
//                    if (INSTANCE == null) {
//                        INSTANCE = ViewModelFactory(Injection.provideRepository(application))
//                    }
//                }
//            }
//            return INSTANCE
//        }
//    }
}