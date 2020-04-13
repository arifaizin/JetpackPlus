package com.arifaizin.core.di

import android.content.Context
import com.arif.jetpackpro.di.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DatabaseModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

//    @Component.Builder interface Builder {
//        fun database(database: MovieDatabase): CoreComponent.Builder
//        fun build(): CoreComponent
//    }
//
//    fun provideDatabase(): MovieDatabase
//    fun provideMovieDao(): MovieDao
}