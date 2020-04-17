package com.arifaizin.jetpackpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.domain.GetAllMoviesUseCase
import com.arifaizin.core.domain.GetAllTvShowUseCase
import com.arifaizin.core.valueobject.Resource

class MovieViewModel(
    private var getAllMoviesUseCase: GetAllMoviesUseCase,
    private var getAllTvShowUseCase: GetAllTvShowUseCase
) : ViewModel() {

    fun getDataMovie(page: Int) : LiveData<Resource<PagedList<MovieModel>>> {
        return getAllMoviesUseCase.invoke(page)
    }

    fun getDataTvShow() : LiveData<Resource<PagedList<TvShowModel>>> {
        return getAllTvShowUseCase.invoke()
    }

}

