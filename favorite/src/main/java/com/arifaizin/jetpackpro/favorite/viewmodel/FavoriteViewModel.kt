package com.arifaizin.jetpackpro.favorite.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.domain.FavoriteInteractor
import com.arifaizin.core.valueobject.Resource

class FavoriteViewModel(private var favoriteInteractor: FavoriteInteractor) : ViewModel() {

    fun getDataMovie(): LiveData<Resource<PagedList<MovieModel>>> = favoriteInteractor.getFavoriteMovies()

    fun getDataTvShow(): LiveData<Resource<PagedList<TvShowModel>>> = favoriteInteractor.getFavoriteTvShow()
}

