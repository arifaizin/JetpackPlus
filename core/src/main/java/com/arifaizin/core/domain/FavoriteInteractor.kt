package com.arifaizin.core.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arifaizin.core.data.datasource.MovieRepository
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource
import javax.inject.Inject

class FavoriteInteractor @Inject constructor(var movieRepository: MovieRepository) : FavoriteUseCase {
    override fun getFavoriteMovies(): LiveData<Resource<PagedList<MovieModel>>> {
        return movieRepository.getFavoriteMovies()
    }

    override fun getFavoriteTvShow(): LiveData<Resource<PagedList<TvShowModel>>> {
        return movieRepository.getFavoriteTvShow()
    }
}