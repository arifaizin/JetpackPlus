package com.arif.jetpackpro.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.arifaizin.core.util.FakeDataDummy
import com.arif.jetpackpro.utils.InstantAppExecutors
import com.arif.jetpackpro.utils.PagedListUtil
import com.arifaizin.core.data.datasource.local.LocalRepository
import com.arifaizin.core.data.datasource.remote.RemoteRepository
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock


class MovieRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val local = mock(LocalRepository::class.java)
    private val remote = mock(RemoteRepository::class.java)
    private val instantAppExecutors = mock(InstantAppExecutors::class.java)
    private val movieRepository = FakeMovieRepository(local, remote, instantAppExecutors)

    private val movieResponses = FakeDataDummy.generateDummyMovies()
    private val tvsShowResponses = FakeDataDummy.generateDummyTvShow()
    private val page: Int = 1

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieModel>
        Mockito.`when`(local.getAllMoviesAsPaged()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies(page)
        val result = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getAllMoviesAsPaged()
        assertNotNull(result.data)
        assertEquals(movieResponses.size, result.data?.size)
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowModel>
        Mockito.`when`(local.getAllTvShowAsPaged()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShow()
        val result = Resource.success(PagedListUtil.mockPagedList(tvsShowResponses))
        verify(local).getAllTvShowAsPaged()
        assertNotNull(result.data)
        assertEquals(tvsShowResponses.size, result.data?.size)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieModel>
        Mockito.`when`(local.getFavoriteMoviesAsPaged()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovies()
        val result = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getFavoriteMoviesAsPaged()
        assertNotNull(result.data)
        assertEquals(movieResponses.size, result.data?.size)
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowModel>
        Mockito.`when`(local.getFavoriteTvShowAsPaged()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTvShow()
        val result = Resource.success(PagedListUtil.mockPagedList(tvsShowResponses))
        verify(local).getFavoriteTvShowAsPaged()
        assertNotNull(result.data)
        assertEquals(tvsShowResponses.size, result.data?.size)
    }
}