package com.arif.jetpackpro.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import com.arif.jetpackpro.valueobject.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class MovieViewModelTest {

    private var viewModel: MovieViewModel? = null
    private val movieRepository = mock(MovieRepository::class.java)
    private val page: Int = 1

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }
    @Test
    fun getDataMovie() {
        val dummyMovies = MutableLiveData<Resource<PagedList<MovieModel>>>()
        val pagedList = mock(PagedList::class.java) as PagedList<MovieModel>
        dummyMovies.value = Resource.success(pagedList)
        `when`(movieRepository.getAllMovies(page)).thenReturn(dummyMovies)
        val observer = mock(Observer::class.java) as Observer<Resource<PagedList<MovieModel>>>
        viewModel?.getDataMovie(page)?.observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))
    }

    @Test
    fun getDataTvShow() {
        val dummyTvShow = MutableLiveData<Resource<PagedList<TvShowModel>>>()
        val pagedList = mock(PagedList::class.java) as PagedList<TvShowModel>
        dummyTvShow.value = Resource.success(pagedList)
        `when`(movieRepository.getAllTvShow()).thenReturn(dummyTvShow)
        val observer = mock(Observer::class.java) as Observer<Resource<PagedList<TvShowModel>>>
        viewModel?.getDataTvShow()?.observeForever(observer)
        verify(observer).onChanged(Resource.success(pagedList))
    }
}