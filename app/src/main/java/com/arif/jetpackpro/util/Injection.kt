package com.arif.jetpackpro.util

import android.app.Application
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.datasource.local.LocalRepository
import com.arif.jetpackpro.datasource.remote.RemoteRepository
import com.arif.jetpackpro.room.MovieDatabase


class Injection {
    companion object {
        fun provideRepository(application: Application): MovieRepository {
            val database = MovieDatabase.getInstance(application)

            val localRepository = LocalRepository.getInstance(database.academyDao())
            val remoteRepository = RemoteRepository.getInstance()
            val appExecutors = AppExecutors()
            return MovieRepository.getInstance(localRepository, remoteRepository, appExecutors)
        }
    }
}