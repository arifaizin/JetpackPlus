package com.arif.jetpackpro.datasource

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.arif.jetpackpro.datasource.remote.RemoteRepository
import com.arifaizin.core.model.movie.MovieModel
import com.arifaizin.core.model.tvshow.TvShowModel
import com.arif.jetpackpro.datasource.local.LocalRepository
import com.arifaizin.core.util.AppExecutors
import com.arifaizin.core.valueobject.Resource
import com.arif.jetpackpro.datasource.remote.ApiResponse


class FakeMovieRepository(
    private var localRepository: LocalRepository,
    private var remoteRepository: RemoteRepository,
    private var appExecutors: AppExecutors
):MovieDataSource {
    override fun getAllMovies(page: Int): LiveData<Resource<PagedList<MovieModel>>> {
        return object : NetworkBoundResource<PagedList<MovieModel>, List<MovieModel>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieModel>> =
                LivePagedListBuilder(localRepository.getAllMoviesAsPaged(), 20).build()

            override fun shouldFetch(data: PagedList<MovieModel>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieModel>>>? =
                remoteRepository.getAllMoviesAsLiveData(page)

            override fun saveCallResult(data: List<MovieModel>) {
                localRepository.insertMovie(data)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<TvShowModel>>> {
        return object : NetworkBoundResource<PagedList<TvShowModel>, List<TvShowModel>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowModel>> =
                LivePagedListBuilder(localRepository.getAllTvShowAsPaged(), 20).build()

            override fun shouldFetch(data: PagedList<TvShowModel>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowModel>>>? =
                remoteRepository.getAllTvShowAsLiveData()

            override fun saveCallResult(data: List<TvShowModel>) {
                localRepository.insertTvShow(data)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<Resource<PagedList<MovieModel>>> {
        return object : NetworkBoundResource<PagedList<MovieModel>, List<MovieModel>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieModel>> =
                LivePagedListBuilder(localRepository.getFavoriteMoviesAsPaged(), 20).build()

            override fun shouldFetch(data: PagedList<MovieModel>?): Boolean = false

            override fun createCall(): LiveData<ApiResponse<List<MovieModel>>>? = null

            override fun saveCallResult(data: List<MovieModel>) {}
        }.asLiveData()
    }

    override fun getFavoriteTvShow(): LiveData<Resource<PagedList<TvShowModel>>> {
        return object : NetworkBoundResource<PagedList<TvShowModel>, List<TvShowModel>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowModel>> =
                LivePagedListBuilder(localRepository.getFavoriteTvShowAsPaged(), 20).build()

            override fun shouldFetch(data: PagedList<TvShowModel>?): Boolean = false

            override fun createCall(): LiveData<ApiResponse<List<TvShowModel>>>? = null

            override fun saveCallResult(data: List<TvShowModel>) {}
        }.asLiveData()    }

    override fun setFavoriteMovie(course: MovieModel, state: Boolean) {
        val runnable = { localRepository.setFavoriteMovie(course, state) }
        appExecutors.diskIO().execute(runnable)
    }

    override fun setFavoriteTvShow(course: TvShowModel, state: Boolean) {
        val runnable = { localRepository.setFavoriteTvShow(course, state) }
        appExecutors.diskIO().execute(runnable)
    }
}