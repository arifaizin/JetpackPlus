package com.arif.jetpackpro.di

//@Module
//class RepositoryModule {
//    @Singleton
//    @Provides
//    fun provideRepository(context: Context): MovieRepository {
//        val database = MovieDatabase.getInstance(context)
//
//        val localRepository = LocalRepository.getInstance(database.movieDao())
//        val remoteRepository = RemoteRepository.getInstance()
//        val appExecutors = AppExecutors()
//        return MovieRepository.getInstance(localRepository, remoteRepository, appExecutors)
//        return MovieRepository(context)
//    }
//
//    @Singleton
//    @Provides
//    fun provideRepository(localRepository: LocalRepository, remoteRepository: RemoteRepository, appExecutors: AppExecutors): MovieRepository {
//        return MovieRepository(localRepository, remoteRepository, appExecutors)
//    }
//
//    @Singleton
//    @Provides
//    fun provideRemote(): RemoteRepository {
//        return RemoteRepository()
//    }
//
//    @Singleton
//    @Provides
//    fun provideExecutors(): AppExecutors {
//        return AppExecutors()
//    }
//}