package com.arif.jetpackpro.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arif.jetpackpro.datasource.MovieRepository
import com.arifaizin.core.model.movie.MovieModel
import com.arifaizin.core.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class FavoriteViewModelTest {

    private var viewModel: FavoriteViewModel? = null
    private val movieRepository = mock(MovieRepository::class.java)

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieRepository)
    }
    @Test
    fun getDataMovie() {
        val dummyMovies = MutableLiveData<Resource<PagedList<MovieModel>>>()
        val pagedList = mock(PagedList::class.java) as PagedList<MovieModel>
        dummyMovies.value = Resource.success(pagedList)
        `when`(movieRepository.getFavoriteMovies()).thenReturn(dummyMovies)
        val observer = mock(Observer::class.java) as Observer<Resource<PagedList<MovieModel>>>
        viewModel?.getDataMovie()?.observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))
    }

    @Test
    fun getDataTvShow() {
        val dummyTvShow = MutableLiveData<Resource<PagedList<TvShowModel>>>()
        val pagedList = mock(PagedList::class.java) as PagedList<TvShowModel>
        dummyTvShow.value = Resource.success(pagedList)
        `when`(movieRepository.getFavoriteTvShow()).thenReturn(dummyTvShow)
        val observer = mock(Observer::class.java) as Observer<Resource<PagedList<TvShowModel>>>
        viewModel?.getDataTvShow()?.observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))
    }
}